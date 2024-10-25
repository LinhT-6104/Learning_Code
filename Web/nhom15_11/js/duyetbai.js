function haveuser(){
    //Lấy thông tin đăng nhập
    var nguoihoatdong = JSON.parse(localStorage.getItem('nguoihoatdong'));
    //nếu không tồn tại người dùng thì quay về đăng
    if (!nguoihoatdong){
        window.location.href='dangnhap.html';
    }
}

// Kiểm tra kiểu người dùng 
function isAdmin() {
    var nguoihoatdong = JSON.parse(localStorage.getItem('nguoihoatdong'));
    let trangduyet = document.getElementById("trangduyet")
    let trangdang = document.getElementById("trangdang")
    let quanli = document.getElementById("quanli")
    let out = document.getElementById("logoutBt")
    let inb = document.getElementById("loginBt")
    if (!nguoihoatdong){
        quanli.style.display = "none"
        trangduyet.style.display = "none"
        trangdang.style.display = "none"
        inb.style.display = "none"
    }
    else{
        if (nguoihoatdong.tennguoidung != "admin123"){
            quanli.style.display = "none"
            trangduyet.style.display = "none"
            out.style.display = "none"
        }
    }
}

// lấy ngày tháng
function dateDate() {
    const dateDisplay = document.getElementById('date');
    const now = new Date();
    const days = ['Chủ Nhật', 'Thứ Hai', 'Thứ Ba', 'Thứ Tư', 'Thứ Năm', 'Thứ Sáu', 'Thứ Bảy'];
    const dayName = days[now.getDay()];
    const day = now.getDate();
    const month = now.getMonth() + 1;
    const year = now.getFullYear();

    dateDisplay.textContent = `${dayName}, ${day}/${month}/${year}`;
}

//điều chỉnh thanh menu theo width
function toggleMenu() {
    const menu = document.getElementById('menu');
    menu.classList.toggle('show');
}

document.addEventListener('DOMContentLoaded', function() {
    
    // ngày tháng
    dateDate();
    haveuser()
    isAdmin()
    let dangxuat = document.getElementById("logoutBt")
    dangxuat.addEventListener('click',function () {
        localStorage.removeItem('nguoihoatdong');
        window.location.href='../index.html';
    })
});

window.onload = themhangall
// save và down bài đăng
function down_local_baidang(){
    danhsachnguoidung = JSON.parse(localStorage.getItem('baidang')) || []
    return danhsachnguoidung
}

function save_local_baidang(danhsachbaidang){
    localStorage.setItem('baidang',JSON.stringify(danhsachbaidang))
}

function themhangall(){
    let danhsachbaidang = down_local_baidang()
    let table = document.getElementById("bangthem")
    table.innerHTML = "";
    let a = 1
    danhsachbaidang.forEach((baidang, index) => {
        let row = table.insertRow()

        let cell1 = row.insertCell(0)
        let cell2 = row.insertCell(1)
        let cell3 = row.insertCell(2)
        let cell4 = row.insertCell(3)
        let cell5 = row.insertCell(4)
        let cell6 = row.insertCell(5)

        cell1.innerHTML = a
        cell2.innerHTML = baidang.tieude
        cell3.innerHTML = baidang.noidung
        cell3.style.width = "700px"
        cell4.innerHTML = baidang.nguoidang;
        cell5.innerHTML = baidang.trangthai;
        
        if (baidang.trangthai === "Chờ duyệt") {
            cell6.innerHTML = `<button id="duyet" onclick="duyet(${index})">Duyệt</button><br>
                                <button id="khongduyet" onclick="khongduyet(${index})">Không duyệt</button><br>
                                <button id="xoa" onclick="xoa(${index})">Xóa</button>`;
        } else if (baidang.trangthai === "Đã duyệt") {
            cell6.innerHTML = `<button id="xem" onclick="xem(${index})">Xem</button><br> 
                                <button id="xoa" onclick="xoa(${index})">Xóa</button>`;
        } else if (baidang.trangthai === "Không duyệt") {
            cell6.innerHTML = `<button id="xoa" onclick="xoa(${index})">Xóa</button>`;
        }
        a++;
})
}

document.getElementById('xemtrangthaiduyet').addEventListener('change', function(e) {
    let danhsachbaidang = down_local_baidang()
    let table = document.getElementById("bangthem")
    table.innerHTML = "";
    let xemtrangthaiduyet = document.getElementById('xemtrangthaiduyet').value

    if (xemtrangthaiduyet == "all"){
        themhangall()
    }
    else if (xemtrangthaiduyet == "ok"){
        themhang("Đã duyệt")
    }
    else if (xemtrangthaiduyet == "no"){
        themhang("Không duyệt")
    }
    else{
        themhang("Chờ duyệt")
    }
});

function duyet(i){
    let danhsachbaidang = down_local_baidang()
    danhsachbaidang[i].trangthai = "Đã duyệt"
    save_local_baidang(danhsachbaidang)
    let xemtrangthaiduyet = document.getElementById('xemtrangthaiduyet').value

    if (xemtrangthaiduyet == "all"){
        themhangall()
    }
    else if(xemtrangthaiduyet == "ok"){
        themhang("Đã duyệt")
    }
}
function khongduyet(i){
    let danhsachbaidang = down_local_baidang()
    danhsachbaidang[i].trangthai = "Không duyệt"
    save_local_baidang(danhsachbaidang)
    let xemtrangthaiduyet = document.getElementById('xemtrangthaiduyet').value

    if (xemtrangthaiduyet == "all"){
        themhangall()
    }
    else if(xemtrangthaiduyet == "no"){
        themhang("Không duyệt")
    }
}

function xoa(i){
    let danhsachbaidang = down_local_baidang()
    danhsachbaidang.splice(i,1)
    save_local_baidang(danhsachbaidang)
    themhangall()
}
function xem(i) {
    localStorage.setItem('baidangchuyenhuong',i)
    window.location.href = "tus.html"
}

function themhang(dieukien){
    let danhsachbaidang = down_local_baidang()
    let table = document.getElementById("bangthem")
    table.innerHTML = ""
    var a = 1
        danhsachbaidang.forEach((baidang, index) => {
            if (baidang.trangthai == dieukien){
                let row = table.insertRow()

                let cell1 = row.insertCell(0)
                let cell2 = row.insertCell(1)
                let cell3 = row.insertCell(2)
                let cell4 = row.insertCell(3)
                let cell5 = row.insertCell(4)
                let cell6 = row.insertCell(5)

                cell1.innerHTML = a;
                cell2.innerHTML = baidang.tieude
                cell3.innerHTML = baidang.noidung
                cell3.style.width = "700px"
                cell4.innerHTML = baidang.nguoidang
                cell5.innerHTML = baidang.trangthai
                if (dieukien === "Chờ duyệt") {
                    cell6.innerHTML = `<button id="duyet" onclick="duyet(${index})">Duyệt</button><br> 
                                        <button id="khongduyet" onclick="khongduyet(${index})">Không duyệt</button><br>
                                        <button id="xoa" onclick="xoa(${index})">Xóa</button>`;
                } else if (dieukien === "Đã duyệt") {
                    cell6.innerHTML = `<button id="xem" onclick="xem(${index})">Xem</button><br> 
                                        <button id="xoa" onclick="xoa(${index})">Xóa</button>`;
                } else if (dieukien === "Không duyệt") {
                    cell6.innerHTML = `<button id="xoa" onclick="xoa(${index})">Xóa</button>`;
                }
                a++
            }   
        })
}