update user set password = '$2y$08$O2.EuUoDI5dtZbySBDzljO3z.BvV0LeGG3exBqKOUEuXcRJwX9KTy' where id = 1;
update user set password = '$2y$08$Lv.hjHfLDUewSx3F3kaaquq8oljpBJv4bE8HdH/nQPvXCqJMzwMe2' where id = 2;
update user set password = '$2y$08$VkK6p5DDRFpsuNzuS6u4yOWFUEiE7R6b7pqqSSJ5mdi0jQoUx9372' where id = 3;

update user_role set roles = 'ROLE_ADMIN' where roles = 'ADMIN';
update user_role set roles = 'ROLE_USER' where roles = 'USER';