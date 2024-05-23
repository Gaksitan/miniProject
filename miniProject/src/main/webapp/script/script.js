	function goBack(){
		location.href = "/mem/myResumeList";
	}
	
	// 추가 버튼 클릭시 작동 (인풋박스, 저장 및 취소 버튼 생성)
	function addRskill() {
		var container = document.getElementById("rskillContainer");
	    var input = document.createElement("input");
	    var inputName = document.createElement("input");
	    var cancelBtn = document.createElement("button");
	    var saveBtn = document.createElement("button");
	    var br = document.createElement("br");
		input.type = "text";
        input.name = "rskill";
        input.placeholder = "스킬명";
        input.id = "shortbox";
        inputName.type = "hidden";
        inputName.name = "rskill"
        
        cancelBtn.type = "button";
        cancelBtn.innerText = "취소";
        cancelBtn.onclick = function(){
        	cancel(input, saveBtn, cancelBtn, br);
        };
        saveBtn.type = "button";
        saveBtn.innerText = "저장";
        saveBtn.onclick = function(){
        	save(input, input.value, saveBtn, cancelBtn, br, inputName);
        }
        container.appendChild(input);
        container.appendChild(saveBtn);
        container.appendChild(cancelBtn);
        container.appendChild(br);
    }
    
	// 생성된 취소 버튼 클릭시 작동
	function cancel(input, saveBtn, cancelBtn, br){
		input.remove();
		saveBtn.remove();
		cancelBtn.remove();
		br.remove();
	}
	
    // 생성된 저장 버튼 클릭시 작동
	function save(input, value, saveBtn, cancelBtn, br, inputName){
		var h5 = document.createElement("h5");
		h5.name
		h5.innerText = "스킬명 : " + value;
		h5.id = "shortbox";
		inputName.value = value;
		var del = document.createElement("button");
		del.type = "button";
		del.innerText = "삭제";
		del.onclick = function(){
			elision(h5);
		}
		input.remove();
		saveBtn.remove();
		cancelBtn.remove();
		br.remove();
		var container = document.getElementById("rskillContainer");
	    container.appendChild(h5);
	    h5.appendChild(inputName);
	    h5.appendChild(del);
	}
	
	// 저장 버튼 클릭시 추가로 삭제버튼 생성 (잘못 입력한 데이터 사용자가 삭제)
	function elision(h5){
		h5.remove();
	}
	
	
	function createInputCell(name) {
        var cell = document.createElement("td");
        var input = document.createElement("input");
        input.type = "text";
        input.name = name;
        cell.appendChild(input);
        return cell;
    }
	
	
	function addRexp() {
		var container = document.getElementById("rexpContainer");
        var newRow = document.createElement("tr");
        var td = document.createElement("td");
        // 입력 값 넣을 필드 생성 - createInputCell(name) 함수 동작시 <td><input type="text" name="name(매개변수)"></td> 생성
        var exnameInput = createInputCell("exname");
        var exjoindateInput = createInputCell("exjoindate");
        var exleavedateInput = createInputCell("exleavedate");
        var expositionInput = createInputCell("exposition");
        var exrankInput = createInputCell("exrank"); 
        // 저장 및 취소 버튼
        var cancelBtn = document.createElement("button");
        var saveBtn = document.createElement("button");
        cancelBtn.type = "button";
        cancelBtn.innerText = "취소";
        cancelBtn.onclick = function(){
        	newRow.remove();
        };
        saveBtn.type = "button";
        saveBtn.innerText = "저장";
        saveBtn.onclick = function(){
        	saveRexp(newRow, exnameInput, exjoindateInput, exleavedateInput, 
        				expositionInput, exrankInput);
        }
        // 위에서 생성된 행(td) 열(tr)에 넣기
        newRow.appendChild(exnameInput);
        newRow.appendChild(exjoindateInput);
        newRow.appendChild(exleavedateInput);
        newRow.appendChild(expositionInput);
        newRow.appendChild(exrankInput);
        
        td.appendChild(saveBtn);
        td.appendChild(cancelBtn);
        newRow.appendChild(td);
        
        container.appendChild(newRow);
    }
    
    
    function saveRexp(newRow, exnameInput, exjoindateInput, exleavedateInput, expositionInput, exrankInput){
		newRow.innerHTML = `
			<td id="shortbox">${exnameInput.querySelector('input').value}<input type="hidden" name="exname" value="${exnameInput.querySelector('input').value}"></td>
			<td id="shortbox">${exjoindateInput.querySelector('input').value}<input type="hidden" name="exjoindate" value="${exjoindateInput.querySelector('input').value}"></td>
			<td id="shortbox">${exleavedateInput.querySelector('input').value}<input type="hidden" name="exleavedate" value="${exleavedateInput.querySelector('input').value}"></td>
			<td id="shortbox">${expositionInput.querySelector('input').value}<input type="hidden" name="exposition" value="${expositionInput.querySelector('input').value}"></td>
			<td id="shortbox">${exrankInput.querySelector('input').value}<input type="hidden" name="exrank" value="${exrankInput.querySelector('input').value}"></td>
			<td><button type="button" onclick="deleteDataTable(event)">삭제</button></td>
		`;
	}
	
	
	function addRdegree() {
		var container = document.getElementById("rdegreeContainer");
        var newRow = document.createElement("tr");
        var td = document.createElement("td");
        // 입력 값 넣을 필드 생성
        var denameInput = createInputCell("dename");
        var degraddateInput = createInputCell("degraddate");
        var demajorInput = createInputCell("demajor");
        var dehighestlevelInput = createInputCell("dehighestlevel"); 
        // 저장 및 취소 버튼
        var cancelBtn = document.createElement("button");
        var saveBtn = document.createElement("button");
        cancelBtn.type = "button";
        cancelBtn.innerText = "취소";
        cancelBtn.onclick = function(){
        	newRow.remove();
        };
        saveBtn.type = "button";
        saveBtn.innerText = "저장";
        saveBtn.onclick = function(){
        	saveRdegree(newRow, denameInput, degraddateInput, demajorInput, dehighestlevelInput, saveBtn, cancelBtn);
        }
        // <tr></tr> 
        newRow.appendChild(denameInput);
        newRow.appendChild(degraddateInput);
        newRow.appendChild(demajorInput);
        newRow.appendChild(dehighestlevelInput);
        
        td.appendChild(saveBtn);
        td.appendChild(cancelBtn);
        newRow.appendChild(td);
        
        container.appendChild(newRow);
    }
    
    
    function saveRdegree(newRow, denameInput, degraddateInput, demajorInput, dehighestlevelInput, saveBtn, cancelBtn){
		newRow.innerHTML = `
			<td>${denameInput.querySelector('input').value}<input type="hidden" name="dename" value="${denameInput.querySelector('input').value}"></td>
			<td>${degraddateInput.querySelector('input').value}<input type="hidden" name="degraddate" value="${degraddateInput.querySelector('input').value}"></td>
			<td>${demajorInput.querySelector('input').value}<input type="hidden" name="demajor" value="${demajorInput.querySelector('input').value}"></td>
			<td>${dehighestlevelInput.querySelector('input').value}<input type="hidden" name="dehighestlevel" value="${dehighestlevelInput.querySelector('input').value}"></td>
			<td><button type="button" onclick="deleteDataTable(event)">삭제</button></td>
		`;
	}
	
	
	
	function addRcertificate() {
		var container = document.getElementById("rcertificateContainer");
        var newRow = document.createElement("tr");
        var td = document.createElement("td");
        // 입력 값 넣을 필드 생성
        var cenameInput = createInputCell("cename");
        var cedateInput = createInputCell("cedate");
        var celocationInput = createInputCell("celocation");
        // 저장 및 취소 버튼
        var cancelBtn = document.createElement("button");
        var saveBtn = document.createElement("button");
        cancelBtn.type = "button";
        cancelBtn.innerText = "취소";
        cancelBtn.onclick = function(){
        	newRow.remove();
        };
        saveBtn.type = "button";
        saveBtn.innerText = "저장";
        saveBtn.onclick = function(){
        	saveRcertificate(newRow, cenameInput, cedateInput, celocationInput, saveBtn, cancelBtn);
        }
        // <tr></tr> 
        newRow.appendChild(cenameInput);
        newRow.appendChild(cedateInput);
        newRow.appendChild(celocationInput);
        
        td.appendChild(saveBtn);
        td.appendChild(cancelBtn);
        newRow.appendChild(td);
        
        container.appendChild(newRow);
    }
    
    
    function saveRcertificate(newRow, cenameInput, cedateInput, celocationInput, saveBtn, cancelBtn){
		newRow.innerHTML = `
			<td>${cenameInput.querySelector('input').value}<input type="hidden" name="cename" value="${cenameInput.querySelector('input').value}"></td>
			<td>${cedateInput.querySelector('input').value}<input type="hidden" name="cedate" value="${cedateInput.querySelector('input').value}"></td>
			<td>${celocationInput.querySelector('input').value}<input type="hidden" name="celocation" value="${celocationInput.querySelector('input').value}"></td>
			<td><button type="button" onclick="deleteDataTable(event)">삭제</button></td>
		`;
	}
	
	
	function addRlink() {
		var container = document.getElementById("rlinkContainer");
        var input = document.createElement("input");
        var inputName = document.createElement("input");
        var cancelBtn = document.createElement("button");
        var saveBtn = document.createElement("button");
        var br = document.createElement("br");
        input.type = "text";
        input.name = "rlink";
        input.placeholder = "스킬명";
        inputName.type = "hidden";
        inputName.name = "rlink"
        cancelBtn.type = "button";
        cancelBtn.innerText = "취소";
        cancelBtn.onclick = function(){
        	cancel(input, saveBtn, cancelBtn, br);
        };
        saveBtn.type = "button";
        saveBtn.innerText = "저장";
        saveBtn.onclick = function(){
        	saveRlink(input, input.value, saveBtn, cancelBtn, br, inputName);
        }
        container.appendChild(input);
        container.appendChild(saveBtn);
        container.appendChild(cancelBtn);
        container.appendChild(br);
    }
    
    
    function saveRlink(input, value, saveBtn, cancelBtn, br, inputName){
		var h5 = document.createElement("h5");
		h5.innerText = value;
		inputName.value = value;
		var del = document.createElement("button");
		del.type = "button";
		del.innerText = "삭제";
		del.onclick = function(){
			elision(h5);
		}
		input.remove();
		saveBtn.remove();
		cancelBtn.remove();
		br.remove();
		var container = document.getElementById("rlinkContainer");
	    container.appendChild(h5);
	    h5.appendChild(inputName);
	    h5.appendChild(del);
	    
	}
    
    
    function deleteData(event){
		var button = event.target;
		button.parentElement.remove();
	}
	
	
	function deleteDataTable(event){
		var button = event.target;
		button.parentElement.parentElement.remove();
	}
	