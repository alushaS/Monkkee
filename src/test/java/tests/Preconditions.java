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
}
