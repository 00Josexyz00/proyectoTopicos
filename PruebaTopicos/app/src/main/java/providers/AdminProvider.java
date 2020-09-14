package providers;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import models.Admin;
import models.Music;

public class AdminProvider {

    DatabaseReference mDatabase;
    public AdminProvider(){
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child("administrar");
    }
    public Task<Void> create(Admin admin){
        return mDatabase.child(admin.getId()).setValue(admin);
    }
}