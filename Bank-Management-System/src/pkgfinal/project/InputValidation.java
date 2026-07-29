package pkgfinal.project;

public class InputValidation {

    public static boolean eMailValidation(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }

    public static boolean UernameAddNewAccount(String username) {
        String regex = "^[a-zA-Z]+\\s[a-zA-Z]+$";
        return username.matches(regex);
    }

    public static boolean usernameValidationForSearch(String username) {
        String regex = "^[a-zA-Z]+$";
        return username.matches(regex);
    }

    public static boolean passwordValidation(String password) {
        String regex = "^{1,30}$";
        return password.matches(regex);
    }

    public static boolean telephoneVerification(String telephoneNumber) {
        String regex = "^(011|012|015|010)\\d{8}$";
        return telephoneNumber.matches(regex);
    }

    public static boolean accountNumberValidation(String accountNumber) {
        String regex = "\\d{10}";
        return accountNumber.matches(regex);
    }

    public static boolean moenyvalidation(String moeny) {
        String regex = "^[1-9]\\d*(\\.\\d+)?$";
        return moeny.matches(regex);
    }

    /*
    Regex, short for Regular Expression, is a powerful tool for pattern matching in strings. It provides a concise and flexible way to search, validate, and manipulate text based on defined patterns.
        Components of Regex
        1. Character Classes
        \d: Matches any digit (0-9).
        \w: Matches any word character (alphanumeric or underscore, [a-zA-Z0-9_]).
        \s: Matches any whitespace character (spaces, tabs, newlines).
        . : Matches any character except a newline.
        2. Quantifiers
        {n}: Matches exactly n occurrences.
        {n,}: Matches at least n occurrences.
        {n,m}: Matches between n and m occurrences.
        *: Matches zero or more occurrences.
        +: Matches one or more occurrences.
        ?: Matches zero or one occurrence.
        3. Anchors
        ^: Matches the start of the string.
        $: Matches the end of the string.
        4. Groups and Ranges
        [abc]: Matches any one of a, b, or c.
        [a-z]: Matches any lowercase letter.
        [0-9]: Matches any digit.
        [^abc]: Matches anything except a, b, or c.
        5. Special Characters (Escaping)
        \.: Matches a literal dot (.).
        \\: Matches a backslash.
        \d, \w, etc., are shorthand for character classes
     */
}
