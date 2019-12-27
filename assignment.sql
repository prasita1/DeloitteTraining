select * from employees
where hire_date> '01-JAN-2008';

select e.first_name,e.hire_date from employees e inner join departments d on e.department_id=d.department_id
where department_name = 'IT' or department_name ='Sales'; 

select job_title, max_salary-min_salary from jobs
where max_salary between 10000 and 20000;

select first_name, salary, round(salary, -3) as rounded_salary from employees;

select * from employees
where hire_date like '%MAY%';

select first_name, hire_date + 30 from employees

select first_name, sysdate-hire_date from employees

select first_name from employees
where hire_date like '%%01';

select initcap(first_name), initcap(last_name) from employees

select job_title from jobs

select length(first_name),last_name from employees
where last_name like '__b%';

select upper(first_name), lower(email) from employees
where upper(first_name)= upper(email);
--
select * from employees
where to_char(hire_date,'yyyy')=to_char(sysdate,'yyyy'); 
--21
select sysdate-to_date('01-01-2011','dd-mm-yyyy') from dual;
--23
select manager_id, count(*) from employees group by manager_id;
--24
select employee_id,
--25
select count(employee_id)
from employees 
where to_char(hire_date,'dd')>15;
--26
select country_id, count(city) from locations
group by country_id;
--27
select avg(salary) from employees
where commission_pct is not null
group by department_id;
--28
select job_id,count(employee_id), sum(salary), max(salary)-min(salary) from employees
group by job_id;
--29
select job_id from employees
group by job_id
having avg(salary)>10000;
--30
select to_char(hire_date,'yyyy'),count(employee_id) from employees
group by to_char(hire_date,'yyyy')
having count(employee_id)>10;
--31
select department_id ,count(commission_pct)
from employees
group by department_id
having count(commission_pct)>5;
--32
select employee_id from job_history
group by employee_id 
having count(department_id)>1
--33
select job_id,count(employee_id) from employees
where round(sysdate-hire_date,-1)>100
group by job_id
having count(employee_id)>3;
--34
select department_id, to_char(hire_date,'yyyy'), count(employee_id)
from employees
group by department_id,to_char(hire_date,'yyyy')
order by department_id;
--35
select distinct department_id,count(employee_id) from employees
group by manager_id,department_id
having count(employee_id)>5;
--36
update employees 
set salary = 8000
where employee_id=115 and salary<6000;
select * from employees where employee_id=115;
--40
select d.department_name,count(e.employee_id)
from employees e join departments d on e.department_id=d.department_id
group by department_name;
--42
select d.department_name, e.first_name
from employees e join departments d on e.department_id=d.department_id
where d.manager_id=e.employee_id;
--45
select j.job_title,d.department_name,e.last_name,h.start_date











