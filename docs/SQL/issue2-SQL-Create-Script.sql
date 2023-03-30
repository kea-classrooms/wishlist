Table User {
  name varchar [not null]
  shared_list_ids int [ref: <> Wishlist.list_id]
  user_id int [pk]
}

Table Computerparts {
  part_id int [pk]
  item_name varchar [not null, unique]
  part_price int
 }

Table Wishlist {
  list_id int [pk]
  user_id int [ref: > User.user_id]
  wish_id int [ref: < Wish.wish_id]
  list_name varchar 
  total_price int
}

Table Wish {
  wish_id int [pk]
  part_id int [ref: > Computerparts.part_id]
  number int 
}