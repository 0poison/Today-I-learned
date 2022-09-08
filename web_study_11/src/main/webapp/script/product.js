function productCheck() {
	if (document.frm.title.value.length == 0) {
		alert("상품명을 써주세요");
		frm.title.focus();

		return false;
	}
	if (document.frm.price.value.length == 0) {
		alert("가격을 써주세요");
		frm.price.focus();
		return false;
	}
	if (isNaN(document.frm.price.value)) {
		alert("숫자를 입력해야 합니다.");
		frm.price.focus();
		return false;
	}

	return true;
}