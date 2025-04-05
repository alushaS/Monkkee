package tests;

import entity.User;

public class Preconditions extends BaseTest{

    protected final User userWithAllEmptyFields = User.builder()
            .email("")
            .password("")
            .passwordConfirmation("")
            .hint("")
            .build();

    protected final User userWithEmptyPasswordConfirmationField = User.builder()
            .email(USER)
            .password(PASSWORD)
            .passwordConfirmation("")
            .hint(HINT)
            .build();

    protected final User userWithAllEmptyFieldsForLogin = User.builder()
            .email("")
            .password("")
            .build();

    protected final User userWithEmptyPasswordForLogin = User.builder()
            .email(USER)
            .password("")
            .build();

    protected final User userWithEmptyEmailForLogin = User.builder()
            .email("")
            .password(PASSWORD)
            .build();
}
