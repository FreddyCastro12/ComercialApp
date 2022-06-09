import { ShoppingCart } from "../../shopping_cart_component/Model/shoppingCart";

export class Client {
    id: number;
    user: String;
    password: String;
    name: String;
    email: String;
    address: String;
    cellPhoneNumber: String;
    shoppingCarts: ShoppingCart[];
    amount: number;
    client_type_id: number;
}