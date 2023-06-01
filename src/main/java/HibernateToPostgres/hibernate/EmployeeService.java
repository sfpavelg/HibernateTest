package HibernateToPostgres.hibernate;


import HibernateToPostgres.entity.Employees;

import java.sql.SQLOutput;

public class EmployeeService {
    private Employees employees;
    public EmployeeService(){
//***** CRUD *****************************************************************
//***** 1. Create ************************************************************
//***** Добавляем работника в БД *********************************************
//        employees = new Employees();
//        employees.setName("Ivan");
//        employees.setSurname("Petrov");
//        employees.setDepartment("Sales");
//        employees.setSalary(5000);
//        new EmployeeDAO().addEmployee(employees);
//*****  Получение работника из БД по id *************************************
//***** 2. Read **************************************************************
//        employees = new EmployeeDAO().getEmployeeById(1);
//        System.out.println("id = " + employees.getId() +
//                ", name = " + employees.getName() +
//                ", surname = " + employees.getSurname() +
//                ", department = " + employees.getDepartment() +
//                ", salary = " + employees.getSalary());
//*****  Обновление данных работника в БД, взятого от туда по id *************
//***** 3. Update Это продолжение пункта №2 **********************************
//        employees.setSalary(6000);
//        new EmployeeDAO().updateEmployee(employees);
//***** Удаление работника из БД по id ***************************************
//***** 4. Delete ************************************************************
        new EmployeeDAO().deleteEmployeeById(10);
//****************************************************************************
    }
}
