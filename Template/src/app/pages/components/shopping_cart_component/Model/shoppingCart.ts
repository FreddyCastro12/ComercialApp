import { Product } from "../../product_client/Model/Product";
import { Service } from "../../service_component/Model/Service";

export class ShoppingCart{
    id: number;
    products: Product[];
    services: Service[];
    cost: number;
    state: string;
}