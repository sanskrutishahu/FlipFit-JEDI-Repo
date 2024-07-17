package com.flipkart.dao;

import com.flipkart.bean.FlipFitGymDetails;
import com.flipkart.bean.FlipFitGymOwner;

import java.util.List;

public class FlipFitAdminDAOImpl implements FlipFitAdminDAOInterface{
    @Override
    public void createAdmin(int adminId, String adminEmail, String adminPassword) {

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
    public void removeGym(int gymId) {

    }

    @Override
    public List<FlipFitGymOwner> viewPendingOwner() {
        return List.of();
    }

    @Override
    public List<FlipFitGymDetails> viewPendingCenter() {
        return List.of();
    }

    @Override
    public void rejectGymRequests(int gymId) {

    }

    @Override
    public void removeGymOwner(int ownerId) {
    }

    @Override
    public void cancelRequest(int ownerId) {
    }
}
