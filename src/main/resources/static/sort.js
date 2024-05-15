

function sortTable1(table, column, asc = true){
    console.log("helo")
    const dirModiefier = asc ? 1: -1;
    console.log(dirModiefier)
    const tBody = table.tBodies[0];
    const rows = Array.from(tBody.querySelectorAll("tr"));

    const sortedRows = rows.sort((a, b)=>{
        const aColText = a.querySelector(`td:nth-child(${column + 1})`).textContent.trim();
        const bColText = b.querySelector(`td:nth-child(${column + 1})`).textContent.trim();

        // console.log(aColText);
        // console.log(bColText);

        const aColValue = isNaN(parseFloat(aColText)) ? aColText : parseFloat(aColText);
        const bColValue = isNaN(parseFloat(bColText)) ? bColText : parseFloat(bColText);




        return aColValue > bColValue ? (1 * dirModiefier) : (-1 * dirModiefier);


    });
    while (tBody.firstChild) {
        tBody.removeChild(tBody.firstChild);
    }

    // Re-add the newly sorted rows
    tBody.append(...sortedRows);

    // Remember how the column is currently sorted
    table.querySelectorAll("th").forEach(th => th.classList.remove("th-sort-asc", "th-sort-desc"));
    table.querySelector(`th:nth-child(${column +1})`).classList.toggle("th-sort-asc", asc);
    table.querySelector(`th:nth-child(${column +1}`).classList.toggle("th-sort-desc", !asc);


}

document.querySelectorAll(".table-sortable th").forEach(headerCell => {
    headerCell.addEventListener("click", () => {
        const tableElement = headerCell.parentElement.parentElement.parentElement;
        const headerIndex = Array.prototype.indexOf.call(headerCell.parentElement.children, headerCell);
        const currentIsAscending = headerCell.classList.contains("th-sort-asc");

        sortTable1(tableElement, headerIndex, !currentIsAscending);
    });
});

function getSortOrder() {
    const sortOrderSelect = document.getElementById("sortOrder");
    console.log(sortOrderSelect.value);
    if(sortOrderSelect.value == "asc")
    {
        console.log("jets")
        return true;
    }
    else{
        return false;
    }



}
