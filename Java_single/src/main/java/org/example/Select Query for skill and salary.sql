/* select from the employee's side */

SELECT *  FROM java_single_schema.employee left join java_single_schema.employee_skill on id = employee_id left join java_single_schema.skill on skills_id = java_single_schema.skill.id;

/* select from the skill's side */
Select  * from java_single_schema.skill 
left join java_single_schema.employee_skill on id = skills_id 
left join employee on java_single_schema.employee_skill.employee_id = java_single_schema.employee.id ;

/* select from the skill's side and filter by skill type */
SELECT *
FROM java_single_schema.skill
LEFT JOIN java_single_schema.employee_skill ON java_single_schema.skill.id = java_single_schema.employee_skill.skills_id
LEFT JOIN java_single_schema.employee ON java_single_schema.employee_skill.employee_id = java_single_schema.employee.id
WHERE java_single_schema.skill.type = 'Bus';

/* employee ID , salary , type */ 
SELECT java_single_schema.employee_skill.employee_id, java_single_schema.employee.salary, java_single_schema.skill.type
FROM java_single_schema.skill
LEFT JOIN java_single_schema.employee_skill ON java_single_schema.skill.id = java_single_schema.employee_skill.skills_id
LEFT JOIN java_single_schema.employee ON java_single_schema.employee_skill.employee_id = java_single_schema.employee.id
WHERE java_single_schema.skill.type = 'Bus';

 /* Name, family name, salary , type */
SELECT java_single_schema.employee.name, java_single_schema.employee.family_name, java_single_schema.employee.salary, java_single_schema.skill.type
FROM java_single_schema.skill
LEFT JOIN java_single_schema.employee_skill ON java_single_schema.skill.id = java_single_schema.employee_skill.skills_id
LEFT JOIN java_single_schema.employee ON java_single_schema.employee_skill.employee_id = java_single_schema.employee.id
WHERE java_single_schema.skill.type = 'Bus';

SELECT java_single_schema.employee.name, java_single_schema.employee.family_name, java_single_schema.employee.salary, java_single_schema.skill.type
FROM java_single_schema.skill
LEFT JOIN java_single_schema.employee_skill ON java_single_schema.skill.id = java_single_schema.employee_skill.skills_id
LEFT JOIN java_single_schema.employee ON java_single_schema.employee_skill.employee_id = java_single_schema.employee.id
WHERE java_single_schema.skill.type = 'Bus'
ORDER BY java_single_schema.employee.salary DESC; 