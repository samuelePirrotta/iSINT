function collapse(element) {
	$(element).toggleClass('active');
}

function changeIcon(element, icon){
	$(element).find("i").toggleClass(icon);
}

//Forza in maiuscolo i campi input
function upper(ustr)
{
	var str = ustr.value;
	var selstart = ustr.selectionStart;

	ustr.value = str.toUpperCase();

	ustr.selectionStart = selstart;
	ustr.selectionEnd = selstart;
}

function valida() {
	var codice = document.datiArticolo.codice.value;
	var descrizione = document.datiArticolo.descrizione.value;
	var ean = document.datiArticolo.ean.value;
	var giacenza = document.datiArticolo.giacenza.value;

	if((codice == "") || (codice == "undefined")) {
		alert("Attenzione! Il campo Codice non puo' essere vuoto");
		document.datiArticolo.descrizione.focus();
		return false;
	}

	if((descrizione == "") || (descrizione == "undefined")) {
		alert("Attenzione! Il campo Descrizione non puo' essere vuoto");
		document.datiArticolo.descrizione.focus();
		return false;
	}

	if(ean != "") {
		if(isNaN(ean)) {
			alert("Attenzione! Il campo EAN deve essere di tipo numerico");
			document.datiArticolo.ean.focus();
			return false;
		}
		if(ean.length != 13) {
			alert("Attenzione! Il campo EAN deve contenere 13 cifre numeriche");
			document.datiArticolo.ean.focus();
			return false;
		}
	}

	if(isNaN(giacenza)) {
		alert("Attenzione! Il campo Giacenza deve essere di tipo numerico");
		document.datiArticolo.giacenza.focus();
		return false;
	}
	if(giacenza <= 0) {
		alert("Attenzione! La Giacenza deve essere maggiore di 0");
		document.datiArticolo.giacenza.focus();
		return false;
	}
	else{
		document.datiArticolo.action = "\AggiungiArticolo";
		document.datiArticolo.submit();
	}
}

function valida2() {
	var giacenza = document.datiArticolo.giacenza.value;
	var ean = document.datiArticolo.ean.value;

	if(ean != "") {
		if(isNaN(ean)) {
			alert("Attenzione! Il campo EAN deve essere di tipo numerico");
			document.datiArticolo.ean.focus();
			return false;
		}
		if(ean.length != 13) {
			alert("Attenzione! Il campo EAN deve contenere 13 cifre numeriche");
			document.datiArticolo.ean.focus();
			return false;
		}
	}

	if(isNaN(giacenza)) {
		alert("Attenzione! Il campo Giacenza deve essere di tipo numerico");
		document.datiArticolo.giacenza.focus();
		return false;
	}
	if(giacenza <= 0) {
		alert("Attenzione! La Giacenza deve essere maggiore di 0");
		document.datiArticolo.giacenza.focus();
		return false;
	}
	else{
		document.datiArticolo.action = "\ModificaArticolo";
		document.datiArticolo.submit();
	}
}

function startScan() {
    document.getElementById('barcode-picker').style.display = "inherit";
    document.getElementById('ean').value = "";
	ScanditSDK.configure("Ab8/KCjTNxrRIQFd+w5gKYsZmx8ZHIle31s5faZzAPWvaPw+6UVhd5FN9EZEbnZH1EsEfpg0UE6NUK4LrmjmEoApGDakdrNaimLDJJd7fXfIFAhXxiBGg+cWx0EOJFwuVR2JpMHMgQiZer48oAEEasMOJ/SCeNTwBhQ7ylrnWT/7qmt0AHEaqmZLhyVO3pVFfxSxNnXIsOaO8plKQG07OKhFR8OEbwZBeGWNJHkxDhNvjimZuR7/gXsfXndCkP4eNp9a906HEg06o+OqNGlpARBC7kG1F6lJhZ8GQZoR7NjRotE6C2xWGZ9OCknMA2lpRa0nCXO3gdYXGoYUFGGlTcAFm7o1PBNw6eURwL0hWkQOgnJKNJ3ZLvKb/8qbhggp6OhAaXKuGU0VUeKEj8C6xOUUa+YApIZawls+llijKufZAu9GJsbzblkmAZ2TsrNlL5JSnHQK/54EfTe887L7Hw1wm08zV9N4NheFjEiC5M1NfWuebpR5ROjjC7oggmZirqmMu++lEhPM3uQFTZQbsNQ3cN04PmFQoY4fDrhgyyJQlho2s4no+hulU3GVcr1QlQtY7Jd2qUt5CVNegIUqvohZsnu8Qc7AH79khHQSS+aUoz+nTXKd6+jyQH2Sidk5fF9agqWXE/FMW7BBUHR3bxCqL4wu2P5QdH/Md97+Y+zG5SHZ1/5AgCU+tVoXGP6sydyTm0YhEzYcOBhms6cc73R6QPBAg5ydkOvICuamA4ZM3MjFY0u9O1qIj2ap9xnE80QczAkBxVQ0zoef9axCld1JkIE0UGxtht0wFc1M", {
		engineLocation: "https://unpkg.com/scandit-sdk/build/"
	}).then(() => {
		ScanditSDK.BarcodePicker.create(document.getElementById('barcode-picker'), {
			playSoundOnScan: true,
			vibrateOnScan: true
		}).then(function(barcodePicker) {
			barcodePicker.applyScanSettings(new ScanditSDK.ScanSettings({
				enabledSymbologies: ["ean8", "ean13", "upca", "upce", "code128", "code39", "code93", "itf", "qr"],
				codeDuplicateFilter: 1000
			}));
			barcodePicker.on("scan", (scanResult) => {
			      document.datiArticolo.ean.value = scanResult.barcodes[0].data;
			      document.getElementById('barcode-picker').style.display = "none";
			});
		});
	});
}