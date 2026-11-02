const menu = [
  { id: 1, name: "Mango Sorbet Brew", price: 5 },
  { id: 2, name: "Tropical Punch", price: 4 },
  { id: 3, name: "Peach Affogato", price: 7 },
  { id: 4, name: "Blueberry Mint Fizz", price: 6 },
  { id: 5, name: "Matcha Vanilla Chiller", price: 8 },
];
const orderMessage = document.querySelector("#order-message");
const orderButtonContainer = document.querySelector("#order-button");
const orderedItemsDiv = document.getElementById("order-list");
const billBreakDownDiv = document.getElementById("bill-breakdown");
const dishSelect = document.querySelector("#dish-select");

let subTotal = 0;
let deliveryCharge = 0;
let discount = 0;
let totalPriceForOrderedItems = 0;
const displayTotalPrice = document.createElement("p");
displayTotalPrice.textContent = `Total : ${totalPriceForOrderedItems}`;
orderedItemsDiv.appendChild(displayTotalPrice);

menu.forEach((dish) => {
  const option = document.createElement("option");

  option.setAttribute("value", dish.id);
  option.textContent = `${dish.name} - $${dish.price}`;
  dishSelect.appendChild(option);
});

const orderList = document.querySelector("#order-list");
const cart = [];

const addToOrderBtn = document.querySelector("#add-to-order");

addToOrderBtn.addEventListener("click", () => {
  const orderEmptyText = document.getElementById("order-empty-text");

  const selectedDishId = Number.parseInt(dishSelect.value);
  const quantity = Number.parseInt(
    document.querySelector("#quantity").value,
    10
  );
  if (Number.isNaN(quantity) || quantity <= 0) {
    alert("Quantity can't be negative");
    return;
  }
  if (Number.isNaN(selectedDishId) || selectedDishId <= 0) {
    alert("Please Select a dish before adding");
    return;
  }

  const selectedDish = menu.find((dish) => dish.id === selectedDishId);

  const orderItem = {
    name: selectedDish.name,
    price: selectedDish.price,
    quantity: quantity,
    total: selectedDish.price * quantity,
  };

  const details = document.createElement("p");
  details.textContent = `${orderItem.name} x ${orderItem.quantity} : $${orderItem.total}`;
  cart.push(orderItem);
  const removeBtn = document.createElement("button");
  removeBtn.textContent = "Remove";
  details.appendChild(removeBtn);
  orderList.appendChild(details);

  totalPriceForOrderedItems += orderItem.total;
  if (removeBtn) {
    removeBtn.addEventListener("click", () => {
      details.remove();
      totalPriceForOrderedItems -= orderItem.total;
      const index = cart.indexOf(orderItem);

      if (index !== -1) {
        cart.splice(index, 1);
      }
      displayTotalPrice.textContent = `Total : ${totalPriceForOrderedItems}`;
      orderedItemsDiv.appendChild(displayTotalPrice);
      if (totalPriceForOrderedItems === 0)
        orderEmptyText.textContent = "Your Order Is Empty";
      else orderEmptyText.textContent = "";
      calculateDiscount();
      return totalPriceForOrderedItems;
    });
  }
  displayTotalPrice.textContent = `Total : ${totalPriceForOrderedItems}`;
  orderedItemsDiv.appendChild(displayTotalPrice);
  if (totalPriceForOrderedItems === 0)
    orderEmptyText.textContent = "Your Order Is Empty";
  else orderEmptyText.textContent = "";
  function calculateDiscount() {
    if (totalPriceForOrderedItems >= 80) {
      discount = totalPriceForOrderedItems * 0.15;
    } else if (totalPriceForOrderedItems >= 50) {
      discount = totalPriceForOrderedItems * 0.1;
    } else if (totalPriceForOrderedItems >= 25) {
      discount = totalPriceForOrderedItems * 0.05;
    } else {
      discount = 0;
    }

    return discount;
  }
  calculateDiscount();
  return {total: totalPriceForOrderedItems, discount: discount};
});

const deliverySelect = document.getElementById("delivery-select");
const placeholder = document.createElement("option");
placeholder.value = "";
placeholder.textContent = "Select delivery location";
placeholder.selected = true;
placeholder.disabled = true;

deliverySelect.appendChild(placeholder);
const deliverableAreas = [
  "Eat-in",
  "Kalyan",
  "Ulhasnagar",
  "Dombivli",
  "Ambernath",
];

deliverableAreas.forEach((area) => {
  const option = document.createElement("option");
  option.value = area;
  option.textContent = area;
  deliverySelect.appendChild(option);
});
if (deliverySelect) {
  deliverySelect.addEventListener("change", () => {
    const area = deliverySelect.value;
    switch (area) {
      case "Eat-in": {
        deliveryCharge = 0;
        break;
      }
      case "Kalyan": {
        deliveryCharge = 5;
        break;
      }
      case "Ulhasnagar": {
        deliveryCharge = 10;
        break;
      }
      case "Dombivli": {
        deliveryCharge = 8;
        break;
      }
      case "Ambernath": {
        deliveryCharge = 10;
        break;
      }
      default: {
        deliveryCharge = 0;
      }
    }
    return deliveryCharge;
  });
}
const placeOrderBtn = document.createElement("button");
placeOrderBtn.textContent = "Place Order";
orderButtonContainer.appendChild(placeOrderBtn);

function orderLogic() {
  const accumaltedPrices = [
    deliveryCharge,
    totalPriceForOrderedItems,
    -discount,
  ];
  subTotal = accumaltedPrices.reduce((accumulator, accumaltedPrice) => {
    return accumulator + accumaltedPrice;
  }, 0);
  return subTotal;
}

function placingOrder(){
    return new Promise((resolve,reject)=>{
        setTimeout(()=>{
            if(cart.length===0)
                reject("Your cart is empty");
            else{
                const orderNo = Math.floor(Math.random()*1000);
                resolve(orderNo);
            }
        },2000);
    });
}
const orderPlaceText = document.createElement("p");
const orderedItemsText = document.createElement("p");
const deliveryChargeText = document.createElement("p");
const discountText = document.createElement("p");
const subTotalText = document.createElement("p");
const billItemsDiv = document.getElementById("bill-items");
if (placeOrderBtn) {
  placeOrderBtn.addEventListener("click", async () => {

  if (cart.length === 0) {
    billItemsDiv.replaceChildren();

    const emptyBillText = document.createElement("p");
    emptyBillText.textContent = "No items to display";
    billItemsDiv.appendChild(emptyBillText);

    orderPlaceText.textContent = "Your cart is empty";
    orderMessage.replaceChildren(orderPlaceText);

    totalPriceForOrderedItems = 0;
    discount = 0;
    subTotal = 0;

    return;
  }

  if (!deliverySelect.value) {
    alert("Add the delivery location please before placing the order");
    return;
  }
    orderPlaceText.textContent = "Placing Order";
    orderMessage.appendChild(orderPlaceText);
    placeOrderBtn.disabled = true;
    try {
      const orderNo = await placingOrder();
      orderLogic();
      orderPlaceText.textContent = `Order Placed Successfully Order No is ${orderNo}`;
      orderedItemsText.textContent = `Ordered Items : $${totalPriceForOrderedItems}`;
      deliveryChargeText.textContent = `Delivery Charge : $${deliveryCharge}`;
      discountText.textContent = `Discount : $${discount}`;
      subTotalText.textContent = `Subtotal : $${subTotal}`;

      billItemsDiv.replaceChildren(
        orderedItemsText,
        deliveryChargeText,
        discountText,
        subTotalText
      );
    } catch (error) {
      orderPlaceText.textContent = error;
    } finally {
      placeOrderBtn.disabled = false;
    }
    console.log(subTotal);
  });
}
