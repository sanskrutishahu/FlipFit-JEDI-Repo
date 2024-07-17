package com.flipkart.business;
import com.flipkart.bean.FlipFitGymOwner;
import java.util.List;

public interface FlipFitAdminInterface {

    public void createAdmin(int adminId, int userId, String userEmail, String userPass);

    public List <FlipFitGymOwner> viewAllGymOwners();

    public List<FlipFitGymOwner> viewGymOwnerDetails(int ownerId);

    public List<FlipFitGymOwner> viewGymOwnerRequests() ;

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
