package hu.ak_akademia.jegyeld.controller;

import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.ak_akademia.jegyeld.dao.user.CreateUserSqlBuilder;
import hu.ak_akademia.jegyeld.dao.user.CreateUserSqlWriter;
import hu.ak_akademia.jegyeld.dao.user.GetUserByEmailSqlBuilder;
import hu.ak_akademia.jegyeld.dao.user.GetUserByEmailSqlWriter;
import hu.ak_akademia.jegyeld.dao.user.UserDao;
import hu.ak_akademia.jegyeld.dao.user.UserSqlReader;
import hu.ak_akademia.jegyeld.dto.User;
import hu.ak_akademia.jegyeld.util.DateUtil;
import hu.ak_akademia.jegyeld.util.PasswordHashGenerator;

public class RegisterNewUser extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lastName = request.getParameter("lastName");
        request.setAttribute("lastName", lastName);
        String firstName = request.getParameter("firstName");
        request.setAttribute("firstName", firstName);
        String dateOfBirth = request.getParameter("dateOfBirth");
        request.setAttribute("dateOfBirth", dateOfBirth);
        String address = request.getParameter("address");
        request.setAttribute("address", address);
        String email = request.getParameter("email");
        request.setAttribute("email", email);
        String phone = request.getParameter("phone");
        request.setAttribute("phone", phone);
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("passwordConfirmation");
        String acceptPrivacyPolicy = request.getParameter("acceptPrivacyPolicy");
        String hashedPassword = new PasswordHashGenerator().createHash(password);
        User user = null;
        try {
            user = new User.Builder().lastName(lastName)
                    .firstName(firstName)
                    .dateOfBirth(DateUtil.toLocalDate(dateOfBirth))
                    .address(address)
                    .email(email)
                    .phone(phone)
                    .password(hashedPassword)
                    .build();
        } catch (DateTimeParseException e) {
            invalidRegistrationAttempt(request, response, "Érvénytelen születési dátum!");
            return;
        }

        UserDao userDao = new UserDao();
        List<User> users = userDao.read(new GetUserByEmailSqlBuilder(), new GetUserByEmailSqlWriter(email), new UserSqlReader());
        if (users.isEmpty()) {
            try {
                validateUser(user);
                validatePassword(password, passwordConfirmation);
                validatePrivacyPolicy(acceptPrivacyPolicy);
            } catch (InvalidInputException e) {
                invalidRegistrationAttempt(request, response, e.getMessage());
                return;
            }
            userDao.create(new CreateUserSqlBuilder(), new CreateUserSqlWriter(user));
            successfulRegistration(request, response, "Sikeres regisztráció! Most már beléphet a megadott adataival.");
            // response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {
            invalidRegistrationAttempt(request, response, "Ezzel az e-mail címmel már létezik felhasználó.");
            return;
        }
    }

    private void validatePrivacyPolicy(String acceptPrivacyPolicy) throws InvalidInputException {
        if (acceptPrivacyPolicy == null) {
            throw new InvalidInputException("Az adatkezelési szabályzatot el kell fogadnia a regisztrációhoz!");
        }
    }

    private void validatePassword(String password, String passwordConfirmation) throws InvalidInputException {
        if (!password.equals(passwordConfirmation)) {
            throw new InvalidInputException("A két jelszó nem egyezik.");
        }
        if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$")) {
            throw new InvalidInputException(
                    "A jelszónak legalább 8 karakter hosszúnak kell lennie, és legalább egy számot, egy kisbetűt, egy nagybetűt és egy speciális karaktert kell tartalmaznia. Szóközt nem tartalmazhat.");
        }
    }

    private void validateUser(User user) throws InvalidInputException {
        validateFirstName(user);
        validateLastName(user);
        validateEmail(user);
        validateAddress(user);
    }

    private void validateFirstName(User user) throws InvalidInputException {
        if (user.getFirstName()
                .length() < 2
                || user.getFirstName()
                        .length() > 50) {
            throw new InvalidInputException("A keresztnév legalább 2, de legfeljebb 50 karakterből állhat.");
        }
    }

    private void validateLastName(User user) throws InvalidInputException {
        if (user.getLastName()
                .length() < 2
                || user.getLastName()
                        .length() > 50) {
            throw new InvalidInputException("A vezetéknév legalább 2, de legfeljebb 50 karakterből állhat.");
        }
    }

    private void validateEmail(User user) throws InvalidInputException {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(user.getEmail());
        if (!matcher.find()) {
            throw new InvalidInputException("Érvénytelen e-mail cím!");
        }
    }

    private void validateAddress(User user) throws InvalidInputException {
        if (user.getAddress() == null || user.getAddress()
                .trim()
                .isEmpty()) {
            throw new InvalidInputException("A cím nem lehet üres.");
        }
    }

    private void invalidRegistrationAttempt(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/registration.jsp");
        request.setAttribute("invalidRegistrationMessage", message);
        dispatcher.forward(request, response);
    }

    private void successfulRegistration(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        request.setAttribute("validRegistrationMessage", message);
        dispatcher.forward(request, response);
    }

}