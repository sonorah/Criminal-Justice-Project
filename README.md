# Authors
This assginment is finished by Sonora Halili and Frankie Fan. We get started on the task together from last Thursday, and completed it early on Monday. With the code review being cancelled on Friday, we completed a large portion of the project by ourselves, and also received clarification from one TA session, as well as the help from professors during class.

# Process
Initially, when we were starting on Phase 0 and Phase 1, we found the code for Onecard as a great reference for building the initial constructors, getters and setters. When we transitted to Phase 2, however, we spent much longer time building the second constructor Defendant(String row), as it confused us a little bit in the beginning. As we bulit a string array list, we had to convert parts of our sliced string into different types of variables, including character, boolean, and integer.

For the TestCode, it was smooth when we tested the constructor and the setters. We spent more time on testStringConstructor(), testBools(), and testFileReader() as they required the modification of the original csv file at some point; one of the funniest modification we made was changing "use false id/name" to "use fake id/name" to avoid letting the word "false" be messed with the boolean value false. We also modified the values in the column two_year_recid manually, as there are many missing or misplaced values that affects the read-in process. The initial CSV file contained values of 0 and 1 in this field, and we had those replaced with true and false. Also, since we sliced up each row where the comma was, we had to modify things like: 3,4 into 3.4, to avoid a few errors we ran into while testing. 

Finally, when we were writing and calling the method proPublica, we could successfully printed out every other step except the exact numbers. Professor Nick helped us during Monday's class by pointing out that there should be a new DefendantGroup created first using the constructor, and then proPublica() should be called on that instance of DefendantGroup. Our last bug was fixed.



# Resource & Exploration
With the code review session being cancelled on last Friday, we've only talked to a few of our classmates about our code. 

- Sylvia Tan and Yuhan Wang   
Sylvia and Yuhan helped to clarify the instruction for building a new contructor Defendant(String row) and the corresponding test code testStringConstructor(). Sylvia explained to us the string array she created for Defendant(String row), which was the exact same idea as ours, made us more confident about our progress in that phase.


- Kristina Ngema  
Kris showed Sonora her code for the testConstructor() part and she was stucked there as it kept returning error message. Sonora helped her to fix a bug by converting a character into a string, and it passed the test. Lateer we realized that the only thing wrong with it was the use of double quotes for a char type, as opposed to single quotes. 


- TA hours   
We got a little confused on the propublica interface, by assuming them as boolean variables when implementing. In the TA session on Sunday, Glory clarified that the code in the interface ProPublica are actually methods, which was very helpful.

# References
Below is a list of resources we've used (include all links here): 

- https://mkyong.com/java/how-to-read-and-parse-csv-file-in-java/ (line 6-9 in DefendantGroup)
- https://stackoverflow.com/questions/7853502/how-to-convert-parse-from-string-to-char-in-java (line 156-157, 163-165 in Defendant)
- https://www.w3schools.com/java/java_interface.asp (for the general idea of implementing interface ProPublica)


# Final Remarks 
There was nothing more satisfying than seeing the table produce almost identical values to the sample table in the propublica article. This assignment took less time than A1 (despite being way more complex), so our two most important getaways from A2 are: 1) time management is very important and saves so much stress, and 2) working on projects that have real life impact is way more rewarding than a made-up chatbot. 
