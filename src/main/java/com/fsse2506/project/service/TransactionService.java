package com.fsse2506.project.service;


import com.fsse2506.project.data.transaction.domainObject.response.TransactionResponseData;
import com.fsse2506.project.data.user.domainObject.request.FirebaseUserData;

public interface TransactionService {

    TransactionResponseData createTransaction(
            FirebaseUserData firebaseUserData);
}
