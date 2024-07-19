package com.flipkart.dao;

import com.flipkart.bean.FlipFitGymDetails;
import com.flipkart.bean.FlipFitGymOwner;
import java.util.List;

public interface FlipFitAdminDAOInterface {

    public void createAdmin(String customUserName, int adminId);

    public List<FlipFitGymOwner> viewAllGymOwners();

    public List<FlipFitGymOwner> viewGymOwnerDetails(int ownerId);

    public List<FlipFitGymOwner> viewGymOwnerRequests();

    public boolean approveGymOwnerRequests(int ownerId);

    public boolean approveGymRequests (int gymId);

    public boolean rejectGymOwnerRequests (int ownerId);

    public boolean removeGym (int gymId);

    public List<FlipFitGymOwner> viewPendingOwner ();

    public List<FlipFitGymDetails> viewPendingCenter();

    public boolean rejectGymRequests (int gymId);

    public boolean removeGymOwner(int ownerId);

    void cancelRequest(int ownerId);

//    public void cancelRequest(int ownerId);



}
