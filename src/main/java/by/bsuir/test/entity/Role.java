package by.bsuir.test.entity;

public enum Role {
    USER(1),
    CUSTOMER(1),
    ADMIN(2),
    PROVIDER(2),
    SUPER_ADMIN(3),
    UNAUTHORIZED_USER;

   private int level;

    Role(int level) {
        this.level = level;
    }

    Role() {
    }

    public static Role of(String name) {
        for (Role role : values()) {
            if (role.name().equalsIgnoreCase(name)) {
                return role;
            }
        }
        return UNAUTHORIZED_USER;
    }
}
