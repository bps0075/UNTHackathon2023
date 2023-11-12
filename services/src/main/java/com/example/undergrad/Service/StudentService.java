package com.example.undergrad.Service;

import com.example.undergrad.Config.ApplicationConfig;
import com.example.undergrad.model.Students;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class StudentService {
    @Autowired
    private ApplicationConfig applicationConfig;

    public StudentService(ApplicationConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
    }

    public Students getStudent(String tripId) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference =
                dbFirestore.collection(applicationConfig.getCollectionName()).document(tripId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Students student;

        if(document.exists()) {
            student= document.toObject(Students.class);
            return student;
        }else {
            return null;
        }
    }
}
