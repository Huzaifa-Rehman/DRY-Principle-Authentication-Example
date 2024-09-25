interface UserAuthenticator {
    boolean authenticate(String username, String password);
}

class DatabaseAuthenticator implements UserAuthenticator {
    @Override
    public boolean authenticate(String username, String password) {
        // Simulate database authentication
        return "user".equals(username) && "pass".equals(password);
    }
}

class OAuthAuthenticator implements UserAuthenticator {
    @Override
    public boolean authenticate(String username, String password) {
        // Simulate OAuth authentication
        return "oauthUser".equals(username) && "oauthPass".equals(password);
    }
}

public class DRY_principle {
    private UserAuthenticator userAuthenticator;

    public DRY_principle(UserAuthenticator userAuthenticator) {
        this.userAuthenticator = userAuthenticator;
    }

    public boolean authenticate(String username, String password) {
        return userAuthenticator.authenticate(username, password);
    }

    public static void main(String[] args) {
        DRY_principle dbService = new DRY_principle(new DatabaseAuthenticator());
        System.out.println("Database Auth: " + dbService.authenticate("user", "pass"));

        DRY_principle oauthService = new DRY_principle(new OAuthAuthenticator());
        System.out.println("OAuth Auth: " + oauthService.authenticate("oauthUser", "oauthPass"));
    }
}
