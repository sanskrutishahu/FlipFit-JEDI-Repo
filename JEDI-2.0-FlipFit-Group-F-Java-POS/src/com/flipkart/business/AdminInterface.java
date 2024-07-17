package com.flipkart.business;
import com.flipkart.bean.GymOwner;

import java.util.List;

public interface AdminInterface {

    public void createAdmin(int adminId, int userId, String userEmail, String userPass);

    public List <GymOwner> viewAllGymOwners();

    public List<GymOwner> viewGymOwnerDetails(int ownerId);

    public List<GymOwner> viewGymOwnerRequests() ;

    public void approveGymOwnerRequests(int ownerId);

    public void approveGymRequests(int gymId);

    public void rejectGymOwnerRequests(int ownerId);

    public void rejectGymRequests(int gymId);

    public void removeGym(int gymId);

    public void viewPendingOwner(int ownerId);

    public void viewPendingCenter(int gymId);

    public void removeGymOwner(int ownerId);

    public void cancelRequest();

}
