package com.sample.filereade

import android.content.Context
import com.google.gson.Gson


class EmployeeData {

    data class EmployeeList(val employees: List<Employee>)

    data class Employee(val name: String, val address:String, val projects: List<String>)

    fun readEmployees(context: Context, fileName: String): List<Employee> {
        val jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        val employeeList = Gson().fromJson(jsonString, EmployeeList::class.java)
        return employeeList.employees
    }
}