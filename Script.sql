
/* Run these if you need to rebuild tables*/
drop table movement;
drop table user_table;
drop table movement_status ;
drop table movement_type ;
drop table userrole_table ;


/*Run this first to populate side tables*/
INSERT INTO public.userrole_table
( user_role)
VALUES( 'User');
INSERT INTO public.userrole_table
(user_role)
VALUES('Admin');
INSERT INTO public.movement_status
(movement_status)
VALUES('Pending');
INSERT INTO public.movement_status
(movement_status)
VALUES('Authorized');
INSERT INTO public.movement_status
(movement_status)
VALUES('Expired');
INSERT INTO public.movement_status
(movement_status)
VALUES('Denied');
INSERT INTO public.movement_type
(movement_type)
VALUES('Educational');
INSERT INTO public.movement_type
(movement_type)
VALUES('Memorial');
INSERT INTO public.movement_type
(movement_type)
VALUES('Emergency');
INSERT INTO public.movement_type
(movement_type)
VALUES('Celebration');
INSERT INTO public.movement_type
(movement_type)
VALUES('Self-Centered');
INSERT INTO public.movement_type
(movement_type)
VALUES('Other');



/*Run this second to add the users*/
INSERT INTO public.user_table
(email, first_name, last_name, "password", user_role_id)
VALUES('guy@guy.com', 'dude', 'derson', '1234', 1);
INSERT INTO public.user_table
(email, first_name, last_name, "password", user_role_id)
VALUES('boss@place.com', 'person', 'derguy', '789', 2);



/*Run this last to add the movements*/
INSERT INTO public.movement
(mov_current, mov_desc, mov_goal, mov_image, mov_start, mov_author, movement_status_id, movement_type_id)
VALUES(10, 'Test', 100, './images/flood.jpg', '2020-06-29T18:25:43.511+0000',  1, 1, 1);
INSERT INTO public.movement
(mov_current, mov_desc, mov_goal, mov_image, mov_start, mov_author, movement_status_id, movement_type_id)
VALUES(10, 'Test', 100, './images/flood.jpg', '2020-06-29T18:25:43.511+0000',  1, 2, 3);
INSERT INTO public.movement
(mov_current, mov_desc, mov_expire, mov_goal, mov_image, mov_start, mov_approver, mov_author, movement_status_id, movement_type_id)
VALUES(200, 'Test2', '2020-06-29T18:25:43.511+0000', 200, './images/flood.jpg', '2020-06-29T18:25:43.511+0000', 2, 1, 3, 6);
INSERT INTO public.movement
(mov_current, mov_desc, mov_goal, mov_image, mov_start, mov_author, movement_status_id, movement_type_id)
VALUES(10, 'Test3', 1000, './images/flood.jpg', '2020-06-29T18:25:43.511+0000',  1, 1, 1);

/*Postman 
 * Get http://localhost:80/movement
 * Get http://localhost:80/movement/status/Pending
 * Get http://localhost:80/user/1
 * Get http://localhost:80/movementType/name/Memorial
 * Get http://localhost:80/movement/type/Educational
 * Get http://localhost:80/movementStatus/name/Pending
 * 
 * Post http://localhost:80/movement
 * {
    "id": 0,
        "goal": 100,
        "current": 10,
        "start": "2020-06-29T22:25:43.511+0000",
        "description": "Test",
        "author": 1,
         "status": 3,
        "type": 2,
        "image": "./images/flood.jpg",
        "expire": null,        
        "approver": null
       
        
        
}
 *
 * Post http://localhost:80/user
 * {
    "id": 0,
    "email": "guy@guy2.com",
    "password": "12345",
    "firstName": "2fsdfddf",
    "lastName": "2dsfdfsfd",
    "userRoleId": 1
}
 * 
 *   */

