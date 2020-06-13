package com.example.whizzz.viewModel;

import android.content.Context;
import android.net.Uri;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.whizzz.services.repository.FirebaseInstanceDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.storage.StorageReference;

public class DatabaseViewModel extends ViewModel {
    private FirebaseInstanceDatabase instance;
    public LiveData<Boolean> successAddUserDb;
    public LiveData<DataSnapshot> fetchUserCurrentData;
    public LiveData<DataSnapshot> fetchUserNames;
    public LiveData<DataSnapshot> fetchSelectedProfileUserData;
    public LiveData<Boolean> successAddChatDb;
    public LiveData<DataSnapshot> fetchedChat;
    public LiveData<StorageReference> imageFileReference;
    public LiveData<Boolean> successAddImageUrlInDatabase;
    public LiveData<Boolean> successAddUsernameInDatabase;
    public LiveData<Boolean> successAddBioInDatabase;


    public DatabaseViewModel() {
        instance = new FirebaseInstanceDatabase();
    }

    public void addUserDatabase(String userId, String userName, String emailId, String timestamp, String imageUrl) {
        successAddUserDb = instance.addUserInDatabase(userId, userName, emailId, timestamp, imageUrl);
    }

    public void fetchingUserDataCurrent() {
        fetchUserCurrentData = instance.fetchUserDataCurrent();
    }

    public void fetchUserNameAll() {
        fetchUserNames = instance.fetchAllUserNames();
    }

    public void fetchSelectedUserProfileData(String userId) {
        fetchSelectedProfileUserData = instance.fetchSelectedUserIdData(userId);
    }

    public void addChatDb(String senderId, String receiverId, String message, String timestamp) {
        successAddChatDb = instance.addChatsInDatabase(senderId, receiverId, message, timestamp);
    }

    public void fetchChatUser() {
        fetchedChat = instance.fetchChatUser();
    }

    public void fetchImageFileReference(String timeStamp, Uri imageUri, Context context) {
        imageFileReference = instance.fetchFileReference(timeStamp, imageUri, context);
    }

    public void addImageUrlInDatabase(String imageUrl, Object mUri) {
        successAddImageUrlInDatabase = instance.addImageUrlInDatabase(imageUrl, mUri);
    }

    public void addBioInDatabase(String bio, Object bioUpdated) {
        successAddBioInDatabase = instance.addBioInDatabase(bio, bioUpdated);
    }

    public void addUsernameInDatabase(String usernameUpdated, Object username) {
        successAddUsernameInDatabase = instance.addUsernameInDatabase(usernameUpdated, username);
    }


}
