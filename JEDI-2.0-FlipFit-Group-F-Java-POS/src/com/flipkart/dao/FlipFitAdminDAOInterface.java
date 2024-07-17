package com.flipkart.dao;

import com.flipkart.bean.FlipFitGymOwner;
import java.util.List;

public interface FlipFitAdminDAOInterface {

    public void createAdmin(int adminId, String adminEmail, String adminPassword);

    public List<FlipFitGymOwner> viewAllGymOwners();

    public List<FlipFitGymOwner> viewGymOwnerDetails(int ownerId);

    public List<FlipFitGymOwner> viewGymOwnerRequests();

    public boolean approveGymOwnerRequest(int ownerId);

    public boolean removeGymOwner(int ownerId);

    public boolean cancelRequest(int ownerId);

}
