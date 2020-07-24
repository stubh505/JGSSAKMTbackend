<img src = "https://github.com/stubh505/JGSSAKMTAdminAndroidApp/blob/master/app/src/main/res/mipmap-xxxhdpi/ic_launcher.png">

# JGSSAKMT Backend

> This is the backend application of the JGSSAKMT project.

> Allows Users to view events, blogs, and pages. 

> Allows Users to read messages sent by users using the contact us Page.

- Structurally complete

- This a java project.

- Project is based on Spring Boot JPA.

- Project uses Heroku PostgreSQL database for data persistance.

<h4>Access the Angular frontend <a href="https://jgssakmt.herokuapp.com/">here</a>.</h4>

## Rest end-points in of the project

<ul><li>/ (Welcome Page)</li>

<li>/BlogsAPI<ul> (All Blog related end points)
<li> /BlogsAPI/getBlog/{id} (Request Param)</li>
<li> /BlogsAPI/addNewBlog (Request Body)</li>
<li> /BlogsAPI/editBlog/{id} (Request Param, Request Body)</li>
<li> /BlogsAPI/deleteBlog/{id} (Request Param)</li>
<li> /BlogsAPI/getAllBlogs</li>
</ul></li>

<li>/EventsAPI<ul> (All Event related end points)
<li> /EventsAPI/getEvent/{id} (Request Param)</li>
<li> /EventsAPI/addNewEvent (Request Body)</li>
<li> /EventsAPI/editEvent/{id} (Request Param, Request Body)</li>
<li> /EventsAPI/deleteEvent/{id} (Request Param)</li>
<li> /EventsAPI/getAllEvents</li>
<li> /EventsAPI/getPastEvents</li>
<li> /EventsAPI/getUpComingEvents</li>
</ul></li>

<li>/PagesAPI<ul> (All Page related end points)
<li> /PagesAPI/getPage/{id} (Request Param)</li>
<li> /PagesAPI/addNewPage (Request Body)</li>
<li> /PagesAPI/editPage/{id} (Request Param, Request Body)</li>
<li> /PagesAPI/deletePage/{id} (Request Param)</li>
<li> /PageAPI/getAllPages</li>
</ul></li>

<li>/ContactUsAPI<ul> (All ContactUs related end points)
<li> /ContactUsAPI/getMessage/{id} (Request Param)</li>
<li> /ContactUsAPI/contactUs (Request Body)</li>
<li> /ContactUsAPI/deleteMessage/{id} (Request Param)</li>
<li> /ContactUsAPI/getMessages</li>
</ul></li>

<li>/CarouselAPI<ul> (All Carousel related end points)
<li> /CarouselAPI/addCarousel (Request Body)</li>
<li> /CarouselAPI/deleteCarousel/{id} (Request Param)</li>
<li> /CarouselAPI/getCarousels</li>
</ul></li>
</ul>

<h4> Back end can be accessed <a href="http://jgssakmtback.herokuapp.com/jgssakmt_backend">here</a>.
