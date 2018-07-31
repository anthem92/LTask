package com.example.lawencon.expandablenew.timesheet;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.lawencon.expandablenew.ExpandableListAdapter;
import com.example.lawencon.expandablenew.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ViewActivity_Timesheet extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    // this is for the Drawer Layout
    private DrawerLayout mDrawerLayout;
    RelativeLayout toolbarMenuRL;

    // this is for addactivity timesheet link
    RelativeLayout add_RL_ActivityTimeSheet;

    // this is for editactivity timesheet link
    ImageButton edit_ActivityTimeSheet;

    //this is
    ImageButton IB_BackTo_timesheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timesheet_viewactivity);

        //this is for the button drawer layout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbarMenuRL = (RelativeLayout) findViewById(R.id.toolbarMenuRL);

        toolbarMenuRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        // this is link to go to the Edit Activity TimeSheet
        edit_ActivityTimeSheet = (ImageButton) findViewById(R.id.Edit_Activity);
        edit_ActivityTimeSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent editactivityTimeSheet = new Intent(ViewActivity_Timesheet.this, EditActivity_TimeSheet.class);
                startActivity(editactivityTimeSheet);
            }
        });

        // this is link to go to the Add Activity TimeSheet
        add_RL_ActivityTimeSheet = (RelativeLayout) findViewById(R.id.relativeLayoutAddActivity);
        add_RL_ActivityTimeSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addactivityTimeSheet = new Intent(ViewActivity_Timesheet.this, AddActivity_TimeSheet.class);
                startActivity(addactivityTimeSheet);
                //finish();
            }
        });

        // this is link to go to the TimeSheet
        IB_BackTo_timesheet = (ImageButton) findViewById(R.id.IB_BackTo_timesheet);
        IB_BackTo_timesheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToTimeSheet = new Intent(ViewActivity_Timesheet.this, TimeSheet.class);
                startActivity(backToTimeSheet);
                finish();
            }
        });

        ShowDrawer();
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

}
