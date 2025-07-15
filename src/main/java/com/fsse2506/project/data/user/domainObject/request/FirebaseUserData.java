package com.fsse2506.project.data.user.domainObject.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class FirebaseUserData {
    private String firebaseUid;
    private String email;
}
