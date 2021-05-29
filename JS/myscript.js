function Computer(code1, company1, model1, basicPrice1, yearofProduction1, kind1, routing1) {
    this.code = code1;
    this.company = company1;
    this.model = model1;
    this.basicPrice = basicPrice1;
    this.yearofProduction = yearofProduction1;
    this.kind = kind1;
    this.routing = routing1;
    this.getbitDetails = function () { return "code-" + " " + this.code + ", " + "company-" + " " + this.company + " ," + "model-" + " " + this.model };

};

function finalcalculation(discount, price) {

    x = (discount * price) / 100;
    x = price - x;
    return x;
};

function print(c) {
    for (x in c) {
        document.getElementById("x").innerHTML+=c.code + " " + c.company + " " + c.model + " " + c.basicPrice + " " + c.yearofProduction + " " + c.kind + " " + c.routing ;
    }
};
var c1 = new Computer(1234, "aa", "x", 1000, 6, "gdsgs", "p1.jpg");
var c2 = new Computer(2344, "ss", "y", 2300, 5, "xdhgr", "p2.jpg");
var c3 = new Computer(4678, "ff", "z", 3500, 10, "dhjt", "p3.jpg");

var computersinstock = [];
computersinstock.push(c1, c2, c3);
var shoppingCart = [];

function getDetails() {
    return "code: " + this.code + " model: " + this.model;
};

function show() {
    for (x of computersinstock) {
        var newdiv = document.createElement("div");
        newdiv.innerHTML += "<br></br>" + x.getbitDetails()+"<br></br>"+"<img src="+x.routing+" style=height:65px;width:65px; >" ;;
        newdiv.classList.add("computer");
        newdiv.id = x.code;
        document.getElementById("x").appendChild(newdiv);
        var b = document.createElement("button");
        b.innerText = "add to basket";
        b.id = x.code;
        newdiv.appendChild(b);
        b.classList.add("button");
        b.addEventListener("click", addtocart, this);
        newdiv.addEventListener("click", getalldetails, this);
        

    }
};

function addtocart() {
    var id = event.currentTarget.id;
    var coputerToCart = computersinstock.find(c => c.code == id);
    shoppingCart.push(coputerToCart);
}

function showcart(){
    document.getElementById("x").innerHTML="" ;
    for(x of shoppingCart){
        document.getElementById("x").innerHTML+=x.code+"<br></br>" ;
    }
}
function getalldetails(){
    var id = event.currentTarget.id;
    var clicked = shoppingCart.find(c => c.code == id);   
    document.getElementById("y").innerHTML= p(clicked);

   
}
function p(x){
    return x.code + " " + x.company + " " + x.model + " " + x.basicPrice + " " + x.yearofProduction + " " + x.kind + " " + x.routing ;

}
/*

var newdiv=document.createElement("div");
       newdiv.innerHTML+="<br></br>"+c.getbitDetails()+"<br></br>"+"<img src="+c.picture+" style=height:65px;width:65px; >" ;
       newdiv.classList.add("computer");
       newdiv.id=c.id;
       newdiv.addEventListener("click", function() {
        document.getElementById("fulldiv").innerHTML =c.getDetails();
      });
       document.getElementById("wrap").appendChild(newdiv);
       var b=document.createElement("button");
       b.innerText="add to basket";
       newdiv.appendChild(b);
       b.classList.add("button")
*/