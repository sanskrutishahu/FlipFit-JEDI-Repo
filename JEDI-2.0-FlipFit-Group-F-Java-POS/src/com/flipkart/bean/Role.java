package com.flipkart.bean;

/**
 * The Role class represents a user role within the FlipFit system.
 * It includes details such as the role ID, role name, and role description.
 */
public class Role {
    private int roleId;
    private String roleName;
    private String roleDescription;

    /**
     * Constructor to initialize a Role object with all fields.
     *
     * @param roleId          the unique identifier for the role
     * @param roleName        the name of the role
     * @param roleDescription a description of the role
     */
    public Role(int roleId, String roleName, String roleDescription) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
    }

    /**
     * Gets the unique identifier for the role.
     *
     * @return the role ID
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * Sets the unique identifier for the role.
     *
     * @param roleId the role ID to set
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    /**
     * Gets the name of the role.
     *
     * @return the role name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Sets the name of the role.
     *
     * @param roleName the role name to set
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * Gets a description of the role.
     *
     * @return the role description
     */
    public String getRoleDescription() {
        return roleDescription;
    }

    /**
     * Sets a description of the role.
     *
     * @param roleDescription the role description to set
     */
    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
