package com.example.akira08.linovess.`object`

import android.support.v4.app.Fragment
import com.example.akira08.linovess.fragment.loanBenefit.benefit_claim
import com.example.akira08.linovess.fragment.profile.employee_profile
import com.example.akira08.linovess.fragment.profile.personal_detail
import com.example.akira08.linovess.fragment.subordinateRequest.subordinate_request
import com.example.akira08.linovess.fragment.timeManagement.*
import com.example.akira08.linovess.fragment.travel.travel_expense
import com.example.akira08.linovess.model.MenuModel

class MenuObject{

    var menu:MutableList<MenuModel> = ArrayList()

    init {

        var header:String
        var body:MutableList<MutableList<Any>>
        var bodyContent:MutableList<Any>
        var drawable:String

        header = "Profile"
        body = ArrayList()

        bodyContent = ArrayList()
        bodyContent.add("Personal Detail")
        bodyContent.add(personal_detail())
        body.add(bodyContent)

        bodyContent = ArrayList()
        bodyContent.add("Employee Profile")
        bodyContent.add(employee_profile())
        body.add(bodyContent)

        drawable = "ic_person"
        var menu1 = MenuModel(header, body, drawable)

        header = "Time Management"
        body = ArrayList()

        bodyContent = ArrayList()
        bodyContent.add("Leave Request")
        bodyContent.add(leave_request())
        body.add(bodyContent)

        bodyContent = ArrayList()
        bodyContent.add("Overtime Request")
        bodyContent.add(overtime_request())
        body.add(bodyContent)

        bodyContent = ArrayList()
        bodyContent.add("Event")
        bodyContent.add(event())
        body.add(bodyContent)

        bodyContent = ArrayList()
        bodyContent.add("Timesheet")
        bodyContent.add(timesheet())
        body.add(bodyContent)

        bodyContent = ArrayList()
        bodyContent.add("Permit Request")
        bodyContent.add(permit_request())
        body.add(bodyContent)

        drawable = "ic_schedule"
        var menu2 = MenuModel(header, body, drawable)

        header = "Loan & Benefit"
        body = ArrayList()

        bodyContent = ArrayList()
        bodyContent.add("Benefit Claim")
        bodyContent.add(benefit_claim())
        body.add(bodyContent)
        drawable = ""
        var menu3 = MenuModel(header, body, drawable)

        header = "Subordinate Request"
        body = ArrayList()

        bodyContent = ArrayList()
        bodyContent.add("Subordinate Request")
        bodyContent.add(subordinate_request())
        body.add(bodyContent)

        drawable = "ic_group"
        var menu4 = MenuModel(header, body, drawable)

        header = "Travel"
        body = ArrayList()

        bodyContent = ArrayList()
        bodyContent.add("Travel Expense")
        bodyContent.add(travel_expense())
        body.add(bodyContent)
        drawable = ""
        var menu5 = MenuModel(header, body, drawable)

        menu.add(menu1)
        menu.add(menu2)
        menu.add(menu3)
        menu.add(menu4)
        menu.add(menu5)

    }

}