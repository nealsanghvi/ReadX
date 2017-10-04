# ReadX
ReadX is a program pioneered to help health specalists analyze their recorded data around the globe. During the AngelHack Hackathon, my team and I came across a project from a health organization called Doctors Without Borders. They needed a software that could search words phonetically from large data sets that they had provided. When doctors as a part of the organization hold clinics and work in hospitals around the world in rural areas, they have to record data about their patients, including their name and more importantly where they are from. Often times, when patients say these things, due to the lack of written language and literacy in the area, doctors simply have to sound out what they think the spelling of their name is, as well as the city they are from. This can cause inconsistency in the way a doctor spells a name or a city from doctor to doctor. 

When this data is aggregated for analysis for the purpose of, for example, epidiemiology and disease prevention research, the data provided is innaccurate. Two data points about one city may actually be counted as two data points for two cities because two doctors spelled the names of the cities differently.  

In order to counter this problem, Doctors without Borders needed to be able to search for one form of a name so that all the similar names pop-up in their search. ReadX will allow you to upload your own excel sheet so you can search for a word via how it sounds. Then you'll be able to search for a name and ReadX will output a list of words that are spelled differently but are the same name.  

PLEASE INSTALL JEXCEL API FROM HERE BEFORE RUNNING THE PROGRAM
  https://sourceforge.net/projects/jexcelapi/files/jexcelapi/2.6.12/

1. Change the directory in the 'List' class to point to your own excel sheet
2. The program is made to automatically detect the keywords 'NAME' and 'ALT_NAME' in the first row of the excel sheet so you'll need your names to be under those columns. You can change the keyword for the column with the list of names in the 'List' method
3. Run the program and it should ask to search for a word
4. It will output a list of words that are spelled verbatim compared to your search or any similar words

SIDE NOTE: The "Old Version" of this project displays everything on a Java Applet. The functionality of the project is the same, this newer version is just a nicer display. Under the old version folder "ReadX" there is also a little UI we were messing around with but didn't have time to complete. 
