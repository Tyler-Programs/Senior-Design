#!/bin/sh
 ## CMPSC 474 /CMPEN 441
 
 #File Name: Begin with "project" and then the project number, for example, proj3.sh 
 
 #Academic Integrity Statement: I certify that, while others may have assisted me in brain storming, debugging and validating this program, the program itself is my own work. I understand that submitting code which is the work of other individuals is a violation of the course Academic Integrity Policy and may result in a zero credit for the assignment, or course failure and a report to the Academic Dishonesty Board. I also understand that if I knowingly give my original work to another individual that it could also result in a zero credit for the assignment, or course failure and a report to the Academic Dishonesty Board. See Academic Integrity Procedural Guidelines at:  
#https://psbehrend.psu.edu/intranet/faculty-resources/academic-integrity/academic-integrity-procedural-guidelines
 
 #Assisted by and Assisted line numbers:
 
 #
 #Your Name: Alex Walkowski
 #
 #Your PSU user ID:  ajw5587
 #
 #CMPSC474 Spring 2016  
 #
 #Due Time: 11:59pm, Thursday, February 4, 2016
 #
 #Time of Last Modification: 8:04pm, Thursday, February 4th, 2016
 #
 #
 # Your codes are here.

#Check if too many arguments were entered
if [ "$1" > 0 ]
then	
	echo "Too many arguments! Run without arguments for this program"
	exit 0
fi

#Prompt and get the user's file to read data from. I will be using data.txt for my testing
echo "Enter the file you wish to get information from"
read filename

#checks to see if the file exists in the directory. If it doesn't then the program exits
if [ -f  "$filename" ]
then
        echo "File Exists"

else
echo "File doesn't exist, exiting program"
exit 0
fi

loopStatus=0

#This is the menu that loops depending on what the user chooses. Each option does what the menu explains.Will loop until 4 is ente#red
while [ $loopStatus != 4 ]   #loop will exit once 4(exit) is selected
do
	opt1="[1] Add Entry"
	opt2="[2] Delete Entry"
	opt3="[3] View Entry"
	opt4="[4] Exit"

	echo $opt1
	echo $opt2
	echo $opt3
	echo $opt4

	read loopStatus

if [ $loopStatus == 1 ]
then
	echo "Enter the Name" 
	read newName
	echo "Enter Phone Number"
	read newNumber
	echo "Enter Address"
	read newAddress
	
	#check to see if the entry is already in it by scanning the file for the name entered
	if grep -q $newName "$filename"; 
	then
		echo "$newName already exists!"
	else 
		echo "$newName : $newNumber : $newAddress"  >> $filename
	fi	
fi

if [ $loopStatus == 2 ]
then
	echo "Enter the name of the entry you wish to delete"
	read deleteThis

	#Searches the file for the keyword the user puts in. If it matches it deletes the whole line of text 
	grep -v "$deleteThis" $filename > temp.txt; mv temp.txt $filename
fi

if [ $loopStatus == 3 ]
then
	echo "***File - $filename contents ***"
	cat $filename
fi

done     #End of while loop
exit 0 
 
 

##  Your sample output is posted below:
if false
then
 
#[ajw5587@psblnx04 lab3]$ ./proj3.sh too many args entered
Too many arguments! Run without arguments for this program
[ajw5587@psblnx04 lab3]$ ./proj3.sh
Enter the file you wish to get information from
data.txt
File Exists
[1] Add Entry
[2] Delete Entry
[3] View Entry
[4] Exit
3
***File - data.txt contents ***
Ryan Maas : 456-678-6532 : 8573 Oak Road
Josh Faust : 4126131221 : 5412 PLeasant
John Doe : 412-234-1222 : 123 Erie Lane
[1] Add Entry
[2] Delete Entry
[3] View Entry
[4] Exit
1
Enter the Name
Alex Walkowski
Enter Phone Number
412-773-0637
Enter Address
104 Village Drive
grep: Walkowski: No such file or directory
[1] Add Entry
[2] Delete Entry
[3] View Entry
[4] Exit
3
***File - data.txt contents ***
Ryan Maas : 456-678-6532 : 8573 Oak Road
Josh Faust : 4126131221 : 5412 PLeasant
John Doe : 412-234-1222 : 123 Erie Lane
Alex Walkowski : 412-773-0637 : 104 Village Drive
[1] Add Entry
[2] Delete Entry
[3] View Entry
[4] Exit
2
Enter the name of the entry you wish to delete
John Doe
[1] Add Entry
[2] Delete Entry
[3] View Entry
[4] Exit
3
***File - data.txt contents ***
Ryan Maas : 456-678-6532 : 8573 Oak Road
Josh Faust : 4126131221 : 5412 PLeasant
Alex Walkowski : 412-773-0637 : 104 Village Drive
[1] Add Entry
[2] Delete Entry
[3] View Entry
[4] Exit
4
[ajw5587@psblnx04 lab3]$ 

fi 
#









