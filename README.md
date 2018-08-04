# Predicting-the-user-s-behavior-of-sharing-bike

Abstract 
This project is of  interest because I always rode the Ubike( the Taiwan sharing bike) in Taiwan and a new company offer the same service at 2016.
This two company have different management methods and create different problems. So, the Analysis of using bikes’ situation may help riders and companies to improve and deal with problems.

Background 
In this project, Some questions want to be discussed and displayed.
How to arrangement the bike can reduce number of bike
1.
Display the workday and holiday influence
2.
Display the temperature and weather influence



Data sources
https://archive.ics.uci.edu/ml/machine-learning-databases/00275/Bike-Sharing-Dataset.zip

This dataset contains the hourly and daily count of rental bikes between years 2011 and 2012 in Capital bike-share system with the corresponding weather and seasonal information.

Analysis
1. Use the Inverted index patterns to find different user’s number level.
2. Use MR Binning pattern to separate different season level to look every day user’s number.
3. Use merge way to combine reg user and cans user give a row have R, C.
4. Use Counting with Counters Pattern to  count see number of rider over hour and temp.
5. Use TopKValues Pattern to catch the top 3 most user hour every day and top 5 temperature and the user number situation.
6. Find max time in every week and look the temperature trend and user trend.

