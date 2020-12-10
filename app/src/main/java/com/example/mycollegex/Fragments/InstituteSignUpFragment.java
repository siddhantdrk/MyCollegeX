package com.example.mycollegex.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.mycollegex.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import com.example.mycollegex.models.CollegeDetails;


public class InstituteSignUpFragment extends Fragment {

    String KEY_NAME = "name";
    String KEY_CONTACT = "contact";
    String KEY_EMAIL = "email";
    String KEY_DOMAIN = "domain";



    private TextInputLayout name, mobile,email,domain;
    private TextInputEditText nameEdit, mobileEdit, emailEdit, domainEdit;
    private ArrayList<CollegeDetails> collegeDetails;
    private FirebaseFirestore db;
    private Button collegeSignUp;


    public InstituteSignUpFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_institute_sign_up, container, false);

        initViews(view);
        collegeDetails = new ArrayList<>();
        getCollegeDetails();

        collegeSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validateContact() && validateName() && validateDomain() && validateEmail())
                {
                    String inputName = Objects.requireNonNull(nameEdit.getText()).toString();
                    if(ValidInstitution())
                    {
                        String nameAdd = nameEdit.getText().toString();
                        String emailAdd = Objects.requireNonNull(emailEdit.getText()).toString();
                        String domainAdd = Objects.requireNonNull(domainEdit.getText()).toString();
                        String contactAdd = Objects.requireNonNull(mobileEdit.getText()).toString();
                        CollegeDetails clgAdd = new CollegeDetails(nameAdd,domainAdd,emailAdd,contactAdd);
                        addInstitution(clgAdd);
                    }
                    else
                    {
                        Toast.makeText(getContext(), "Not Valid", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        return view;
    }

    private void initViews(View view)
    {
        nameEdit = view.findViewById(R.id.name_edit_text);
        mobileEdit = view.findViewById(R.id.mob_edit_text);
        emailEdit = view.findViewById(R.id.email_edit_text);
        domainEdit = view.findViewById(R.id.domain_edit_text);
        collegeSignUp = view.findViewById(R.id.institute_sign_up_btn);
    }

    private void getCollegeDetails()
    {
        collegeDetails.clear();

        db = FirebaseFirestore.getInstance();

        db.collection("College")
            .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.getResult() != null && task.isSuccessful())
                        {
                            for(QueryDocumentSnapshot documentSnapshot : task.getResult())
                            {
                                String nameCLG = (String) documentSnapshot.get(KEY_NAME);
                                String emailCLG = (String) documentSnapshot.get(KEY_EMAIL);
                                String domainCLG = (String) documentSnapshot.get(KEY_DOMAIN);
                                String contactCLG = (String) documentSnapshot.get(KEY_CONTACT);
                                CollegeDetails clg = new CollegeDetails(nameCLG,domainCLG,emailCLG,contactCLG);
                                collegeDetails.add(clg);
                            }
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getContext(), "Some Error Occurred", Toast.LENGTH_SHORT).show();

                    }
                });
    }

    private boolean validateName()
    {
        return Objects.requireNonNull(nameEdit.getText()).toString().length() > 0;
    }

    private boolean validateContact()
    {
        return Objects.requireNonNull(mobileEdit.getText()).toString().length() == 10;
    }

    private boolean validateDomain()
    {
        return Objects.requireNonNull(domainEdit.getText()).toString().length() > 0 && domainEdit.getText().toString().startsWith("@");
    }


    private boolean validateEmail()
    {
        return Objects.requireNonNull(emailEdit.getText()).toString().length() > 0;
    }


    private boolean ValidInstitution()
    {
        for(CollegeDetails element : collegeDetails)
        {
            if(element.getName().toLowerCase().equals(Objects.requireNonNull(nameEdit.getText()).toString().toLowerCase().trim()))
            {
                Toast.makeText(getContext(), "Matched Existing", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        return true;
    }

    private void addInstitution(CollegeDetails clgDet)
    {
        HashMap<String,Object> map = new HashMap<>();
        map.put(KEY_NAME,clgDet.getName());
        map.put(KEY_EMAIL,clgDet.getEmail());
        map.put(KEY_DOMAIN,clgDet.getDomain());
        map.put(KEY_CONTACT,clgDet.getContact());

        db.collection("College").document(clgDet.getName())
                .set(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getContext(), "Add SuccessFull", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getContext(), "Failure", Toast.LENGTH_SHORT).show();
                    }
                });
    }

}