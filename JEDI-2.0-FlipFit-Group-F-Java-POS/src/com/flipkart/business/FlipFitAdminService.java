package com.flipkart.business;
import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

public class FlipFitAdminService implements FlipFitAdminInterface {


    @Override
    public void createAdmin(int adminId, int userId, String userEmail, String userPass) {

    }

    @Override
    public List<FlipFitGymOwner> viewAllGymOwners() {
        return List.of();
    }

    @Override
    public List<FlipFitGymOwner> viewGymOwnerDetails(int ownerId) {
        return List.of();
    }

    @Override
    public List<FlipFitGymOwner> viewGymOwnerRequests() {
        return List.of();
    }

    @Override
    public void approveGymOwnerRequests(int ownerId) {

    }

    @Override
    public void approveGymRequests(int gymId) {

    }

    @Override
    public void rejectGymOwnerRequests(int ownerId) {

    }

    @Override
    public void rejectGymRequests(int gymId) {

    }

    @Override
    public void removeGym(int gymId) {

    }

    @Override
    public void viewPendingOwner(int ownerId) {

    }

    @Override
    public void viewPendingCenter(int gymId) {

    }

    @Override
    public void removeGymOwner(int ownerId) {

    }

    @Override
    public void cancelRequest() {

    }
}
