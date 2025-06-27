📖 CS320 Software Testing, Automation QA
🏫 Southern New Hampshire University

1️⃣ How can I ensure that my code, program, or software is functional and secure?
   First, I conduct a thorough dry run to catch any typographical errors, ensuring everything is on point.
   Then, I review the product requirements to ensure that the necessary constraints are in place for the input data types,
   verifying that they meet the requirements before storing the data. For instance, I wrote JUnit tests to prevent null
   or duplicate contact entries and to ensure that appointment dates are not in the past. Additionally, I created
   tests to confirm that the core operations function as expected, allowing users to create, edit, update, and delete
   objects, with only the ID being immutable. For security considerations, I set all data types to String and ensure that no
   raw data is stored. This approach not only avoids hardcoded values but also enhances protection against injection
   vulnerabilities, ensuring a secure and reliable system for users.

2️⃣ How do I interpret user needs and incorporate them into a program?
   I believe the end user wants to easily manage their daily tasks, appointments, and contacts. It is essential for users to have the ability 
   to perform CRUD operations and have unique identifiers for tracking purposes. To better organize the data, each contact, task, or 
   appointment should have a unique ID assigned when created. This will allow users to clearly identify each object when they want to delete, 
   update, or simply view the information again.
  
3️⃣ How do I approach designing software?
   When designing software, I start by breaking the problem into smaller, manageable parts. For my project, I created separate services for 
   contacts, appointments, and tasks, which helped organize the system and made it easier to test. I prioritize maintaining clean and 
   purposeful code, and I always consider how the program might expand or integrate with other systems in the future.
