package com.flipkart.business;

import com.flipkart.bean.GymOwner;

import java.util.List;

public interface AdminInterface {

    public void createAdmin(int adminId, String username, String password);

    public List <GymOwner> viewAllGymOwners();

    public List<GymOwner> viewGymOwnerDetails(int ownerId);

    public void approveGymOwnerRequests(int ownerId);

    public void approveGymRequests(int gymId);

    public void rejectGymOwnerRequests(int ownerId);

    public void rejectGymRequests(int ownerId);

    public void removeGym(int ownerId);

    public void viewPendingOwner(int ownerId);

    public void viewPendingCenter(int ownerId);

    public void removeGymOwner(int ownerId);

    public void cancelRequest(int ownerId);

}
