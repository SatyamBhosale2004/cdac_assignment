const menu = [
  { id: 1, name: "Mango Sorbet Brew", price: 5 },
  { id: 2, name: "Tropical Punch", price: 4 },
  { id: 3, name: "Peach Affogato", price: 7 },
  { id: 4, name: "Blueberry Mint Fizz", price: 6 },
  { id: 5, name: "Matcha Vanilla Chiller", price: 8 },
];

const dishSelect = document.querySelector("#dish-select");

menu.forEach((dish)=>{
    const option = document.createElement("option");

    option.setAttribute("value",dish.id);
    option.textContent = `${dish.name} - $${dish.price}`;
    dishSelect.appendChild(option);
});
const orderList = document.querySelector("#order-list");    
const cart = [];

const addToOrderBtn = document.querySelector("#add-to-order");

addToOrderBtn.addEventListener("click",()=>{
    const selectedDishId = Number.parseInt(dishSelect.value);
    const quantity = Number.parseInt(document.querySelector("#quantity").value,10);
    if (Number.isNaN(quantity) || quantity < 0) {
      alert("Quantity can't be negative");
      return;
    }

    if(Number.isNaN(selectedDishId) || selectedDishId <= 0){
        alert("Please Select a dish before adding");
        return;
    }

    const selectedDish = menu.find(dish => dish.id === selectedDishId);

    const orderItem = {
        name: selectedDish.name,
        price: selectedDish.price,
        quantity: quantity,
        subTotal: selectedDish.price*quantity
    };
    const details = document.createElement("p");
    details.textContent=`${orderItem.name} x ${orderItem.quantity} : $${orderItem.subTotal}`;
    cart.push(orderItem);
    cart.forEach((item)=>{
        orderList.appendChild(details);
    });
    
});



