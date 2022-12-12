# Demo_Video: 

Zoom: https://bostonu.zoom.us/rec/share/I4evDiGOm2a7z5WyPHiu_j9-WiGtzsQx5-MBe-xZTUDC4f1KHwOPhBI1hVNlswiM.jpbxOagskJJsuwDg 

Passcode: n+j+Sa7X

# CS411_Project

Topic: Solar (check detailed information in the following pitch)

Frontend: React

Backend: Java 
Framework: Spring Boot

Database: MySQL (deploy to Amazon RDS for better simplicty and scalability)

API: Google Map API, Solcast API

# Backend_Design_Diagram

<img width="1047" alt="Screen Shot 2022-12-12 at 5 05 22 PM" src="https://user-images.githubusercontent.com/87915617/207165331-ba52f937-4162-49ad-a8b9-55c9ea7bafdc.png">

# Data_Modeling

<img width="956" alt="Screen Shot 2022-12-12 at 5 05 27 PM" src="https://user-images.githubusercontent.com/87915617/207165392-d608e56b-af59-42dc-9cf9-8be3c6f8f014.png">

# Pitch

Top 1. Solar:

This app will allow people to see how much money and energy they could save by switching to solar power. Users can login to their utility provider (Coned, PECO) using the utilityapi and we can query which utilities they're looking to "solarize" according to subsequent form data. The form will also include details about their household: address, number of residents, avg utility costs, etc. From there, we can see how much energy solar solutions would generate according to the solcast API, which forecasts data for irradiance and PV power. The formula E = A x r x H x PR (Read more at: https://www.saurenergy.com/solar-energy-blog/here-is-how-you-can-calculate-the-annual-solar-energy-output-of-a-photovoltaic-system) will yield the kWh, which we can compare to the kWh from utilityapi. We will also show state solar tax incentives using this database (https://www.dsireusa.org/resources/data-and-tools/). Users can also see if their community offers community solar solutions by querying this database(https://data.nrel.gov/submissions/149). The community solar optionality will allow everyone the potential to benefit through our app, even if their property is not well suited to rooftop solar or they lack the means to implement it fully (such as renters).

to consider:
https://eta-publications.lbl.gov/sites/default/files/lbnl-6942e.pdf --> can calculate the increased home value of solar friendly home based on kWh/PV output.
https://www.epa.gov/energy/greenhouse-gas-equivalencies-calculator#results --> shows the equivalency of emissions avoided

Top 2. Travel Planner: 

When we are planning the trips, what we do is gather information from many platforms such as google, yelp, and social media. We need to do a lot of research and spend a lot of time planning the trip. So what we want to design is to provide a platform that can gather and process the information in the recommendation system to generate a travel plan which meets users' preferences and save them time.

The travel planner we would like to design is a full-stack web application. Users can register for an account, log in, and log out. Users can input the name of the city and the number of days that they would like to travel and spend. Then this application will give users a few options of three main categories: attractions, restaurants, and hotels which users can choose and users can choose more than 1 option. For example, the options of attractions could be adventure paths, romantic escapes, travel with kid(s), classic type, and sophisticated mind. After users decide their preferences for three categories. The application will generate a report which is the travel plan for users showing the recommended hotel, brunch restaurant, dinner restaurant, and attractions, and their names, locations, price points, reviews, and pictures. We may design a swap feature that can allow users to click the "swap" button to change another recommended one if they don't like it for each section in the report. We can use Machine Learning models for our recommendation system to provide users with an optimized plan.

The APIs we can use are Google, Yelp, and Amedeus APIs to get the information of the type of attractions, restaurants, and hotels, their locations, latitude and longtitude, price points, reviews.
  APIs/Datasets:
   > https://developers.google.com/maps/documentation/places/web-service/overview - Google place APIs
   > https://www.yelp.com/developers/documentation/v3/get_started - Yelp APIs
   > https://developers.amadeus.com/self-service/category/covid-19-and-travel-safety/api-doc/safe-place/api-reference - Amadeus place APIs


Backup: Util:

Many people, myself included, have issues tracking recurring payments. Some of the largest of these payments are utility bills, such as monthly AC, electric, or water bills. This app will help users track their bills: when they recur, how much they pay, and how their payments stack up versus nearby payments/providers. Users can register for accounts for a streamlined dashboard, where their bills pop up in the order they're due.
   > https://data.boston.gov/dataset/city-of-boston-utility-data 
   > https://utilityapi.com/
   

Backup: Boston Delivery Management System Web Application: 

Design a drone & robot delivery management system. We have a few bases in Boston to send out drone & robot to delivery package. Users can type their name pickup address, recevier's name and delivery address to create order in the order interface. The recommendation system generate delivery plans based on users' inputs in the plan interface. Users can also register for an account and login/logout to review their delivery status. Use Google Geolocation API or Pubnub to visualize the delivery status on the Google Map.
  APIs/Datasets: Google API(text search)/Pakage delivery time/Google Geolocation API
> https://kilthub.cmu.edu/articles/dataset/Data_Collected_with_Package_Delivery_Quadcopter_Drone/12683453?file=26405936 -- info on drone deliveries
> https://data.boston.gov/dataset/traffic-related-data -- info on boston traffic, for contrast w/ drone services





