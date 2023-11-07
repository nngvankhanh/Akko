function addNewProduct() {
    //lay du lieu
    let id = $('#idA').val();
    let name = $('#nameA').val();
    let quantity = $('#quantityA').val();
    let price = $('#priceA').val();
    let categoryId = $('#categoryA').val();
    let sellerId= 1;
    let newProduct = {
        id: id,
        name: name,
        quantity: quantity,
        price: price,
        categoryId: categoryId,
        sellerId: sellerId
    };
    // console.log(newProduct)
    // goi ajax
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newProduct),
        //tên API
        url: "/seller/manager/save",
        //xử lý khi thành công
        success: function (){
            successHandler();
            $('#exampleModalA').modal('hide')
            console.log("success");
        }

    });
    //chặn sự kiện mặc định của thẻ
    event.preventDefault();
}

function successHandler() {
    $.ajax({
        type: "GET",
        //tên API
        url: "/seller/manager/list",
        //xử lý khi thành công
        success: function (data) {
            console.log(data)
            // hien thi danh sach o day
            let content = '<tr>\n' +
                '                      <th scope="col">STT</th>\n' +
                '                      <th scope="col">Tên sản phẩm</th>\n' +
                '                      <th scope="col">Giá bán</th>\n' +
                '                      <th scope="col">Số lượng</th>\n' +
                '                      <th scope="col"></th>\n' +
                '                    </tr>';
            for (let i = 0; i < data.length; i++) {
                content += getProduct(data[i],i);
            }
            $("#productList").html(content);
        }
    });
    //chặn sự kiện mặc định của thẻ
    event.preventDefault();
}
function getProduct(product,i) {
    return `<tr>
                              <th scope="row">${++i}</th>
                              <td>${product.name}</td>
                              <td>${product.price}</td>
                              <td>${product.quantity}</td>
                              <td>
                                <div class="">
                                  <a href="#" class="btn btn-outline-info m-1" onclick="editProduct(${product.id})"><i class="ti ti-edit"></i> Chỉnh sữa</a>
                                  <a href="#" class="btn btn-outline-danger m-1" onclick="verifyDeleteId(${product.id})"><i class="ti ti-circle-minus"></i> Xóa</a>
                                </div>
                              </td>
                            </tr>`;
}

$(document).ready(function () {
    //sư kiện nào thực hiện Ajax
    $('.verifyDelete').click(function (event) {
        //lay du lieu
        let a = $(this);
        let id = a.attr("href");
        $('#idDelete').val(id);
        event.preventDefault();
        $('#exampleModalCenter').modal('show');
    });
})
function verifyDeleteId(id) {
    $('#idDelete').val(id);
    $('#exampleModalCenter').modal('show');
}
function deleteProduct(){
    let productId = $('#idDelete').val();
    $.ajax({
        type: "DELETE",
        //tên API
        url: `/seller/manager/delete/${productId}`,
        //xử lý khi thành công
        success: function (data) {
            // a.parent().remove().load();
            // a.parents('tr').remove();
            successHandler();
            $('#exampleModalCenter').modal('hide')
        }
    });
}
$(document).ready(function () {
    //sư kiện nào thực hiện Ajax
    $('.editProduct').click(function (event) {
        //lay du lieu
        let a = $(this);
        let productId = a.attr("href");
        // goi ajax
        $.ajax({
            type: "GET",
            //tên API
            url: `/seller/manager/edit/${productId}`,
            //xử lý khi thành công
            success: function (data) {
                $('#id').val(data.id);
                $('#name').val(data.name);
                $('#quantity').val(data.quantity);
                $('#price').val(data.price);
                $('#category').val(data.categoryId);
                $('#sellerId').val(data.sellerId);

                $('#exampleModal').modal('show');
            }
        });
        //chặn sự kiện mặc định của thẻ
        event.preventDefault();
    });
})
function editProduct(id){
    let productId = id;
    $.ajax({
        type: "GET",
        //tên API
        url: `/seller/manager/edit/${productId}`,
        //xử lý khi thành công
        success: function (data) {
            $('#id').val(data.id);
            $('#name').val(data.name);
            $('#quantity').val(data.quantity);
            $('#price').val(data.price);
            $('#category').val(data.categoryId);
            $('#sellerId').val(data.sellerId);

            $('#exampleModal').modal('show');
            // $('#btnUpdate').show();
            // successHandler();
        }
    });
}
function updateProduct() {
    //lay du lieu
    let id = $('#id').val();
    let name = $('#name').val();
    let quantity = $('#quantity').val();
    let price = $('#price').val();
    let categoryId = $('#category').val();
    let sellerId = $('#sellerId').val();
    let newProduct = {
        id: id,
        name: name,
        quantity: quantity,
        price: price,
        categoryId: categoryId,
        sellerId: sellerId,
    };
    // goi ajax
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newProduct),
        //tên API
        url: "/seller/manager/save",
        //xử lý khi thành công
        success: function (response){
            successHandler();
            $('#exampleModal').modal('hide');
            console.log("success");
        }

    });
    //chặn sự kiện mặc định của thẻ
    event.preventDefault();
}
function closeModal(){
    $('#exampleModal').modal('hide')
    $('#exampleModalCenter').modal('hide')
    $('#exampleModalA').modal('hide')
}
