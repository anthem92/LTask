package com.example.lawencon.expandablenew;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.lawencon.expandablenew.personalDetail.create_address;
import com.example.lawencon.expandablenew.personalDetail.create_basicInformation;
import com.example.lawencon.expandablenew.personalDetail.create_contactInfo;
import com.example.lawencon.expandablenew.personalDetail.create_document;
import com.example.lawencon.expandablenew.personalDetail.create_externalTraining;
import com.example.lawencon.expandablenew.personalDetail.create_familyMember;
import com.example.lawencon.expandablenew.personalDetail.create_personality;
import com.example.lawencon.expandablenew.timesheet.TimeSheet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    // this is for the Drawer Layout
    private DrawerLayout mDrawerLayout;
    RelativeLayout toolbarMenuRL;

    ImageButton btnCreateBasicInformation, btnCreateContactInfo, btnCreatePersonality,
            btnCreateAddress, btnFamilyMember, btnExternalTraining, btnDocument;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this is for the button drawer layout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbarMenuRL = (RelativeLayout) findViewById(R.id.toolbarMenuRL);

        toolbarMenuRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        ShowDrawer();

        buttonCreate();

    }

    private void buttonCreate(){
        // for button Create Basic Information
        btnCreateBasicInformation = (ImageButton) findViewById(R.id.create_BasicInformation);
        btnCreateBasicInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_createBasicInformation = new Intent(MainActivity.this, create_basicInformation.class);
                startActivity(intent_createBasicInformation);

                //finish();
            }
        });

        // for button Create Contact Info
        btnCreateContactInfo = (ImageButton) findViewById(R.id.create_ContactInfo);
        btnCreateContactInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_createContactInfo = new Intent(MainActivity.this, create_contactInfo.class);
                startActivity(intent_createContactInfo);

//                finish();
            }
        });

        // for button Create Personality
        btnCreatePersonality = (ImageButton) findViewById(R.id.create_Personality);
        btnCreatePersonality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_createPersonality = new Intent(MainActivity.this, create_personality.class);
                startActivity(intent_createPersonality);

//                finish();
            }
        });

        // for button Create Address
        btnCreateAddress = (ImageButton) findViewById(R.id.create_Address);
        btnCreateAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_createAddress = new Intent(MainActivity.this, create_address.class);
                startActivity(intent_createAddress);

//                finish();
            }
        });

        // for button Family Member
        btnFamilyMember = (ImageButton) findViewById(R.id.create_FamilyMember);
        btnFamilyMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_createFamilyMember = new Intent(MainActivity.this, create_familyMember.class);
                startActivity(intent_createFamilyMember);

//                finish();
            }
        });

        // for button External Training
        btnExternalTraining = (ImageButton) findViewById(R.id.create_ExternalTraining);
        btnExternalTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_createExternalTraining = new Intent(MainActivity.this, create_externalTraining.class);
                startActivity(intent_createExternalTraining);

//                finish();
            }
        });

        // for button Document
        btnDocument = (ImageButton) findViewById(R.id.create_Document);
        btnDocument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_createDocument = new Intent(MainActivity.this, create_document.class);
                startActivity(intent_createDocument);

//                finish();
            }
        });

    }

    private void ShowDrawer(){

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.ELV_menu);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {

                if(listDataHeader.equals("Time Management")){
                    Intent intent = new Intent(MainActivity.this, TimeSheet.class);
                    startActivity(intent);
                }
                 //Toast.makeText(getApplicationContext(),
                 //"Group Clicked " + listDataHeader.get(groupPosition),
                 //Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });


        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });

    }

    //Preparing the list data
    private void prepareListData(){
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        //child data
        listDataHeader.add("Profile");
        listDataHeader.add("Time Management");

        List<String> profile = new ArrayList<String>();
        profile.add("Personal Detail");
        profile.add("Employee Profile");

        List<String> timeManagement = new ArrayList<String>();
        timeManagement.add("Leave Request");
        timeManagement.add("Overtime Request");
        timeManagement.add("Event");
        timeManagement.add("Time Sheet");
        timeManagement.add("Permit Request");
        timeManagement.add("Overtime Order");
        timeManagement.add("Work Sheet");

        listDataChild.put(listDataHeader.get(0), profile );
        listDataChild.put(listDataHeader.get(1), timeManagement);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}
