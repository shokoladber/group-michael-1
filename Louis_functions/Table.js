//Look at orbit report for examples of a dynamic table written in React (ﾉ> ω Ф)ﾉ
const Table = ({seedData}) =>{
    return(
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Rarity</th>
                    <th>Zone</th>
  {/* May need to get more specific here, figure out if care requirements should be multiple columns or if that should 
        be saved for advanced search/stretch goal
                    <th>Care Requirements</th> */}
                    <th>Indigenous Source</th>
                </tr>
            </thead>
            <tbody>
                {seedData.map((data, id) =>
                <tr>
                    <td>{data.name}</td>
                    <td>{data.rarity}</td>
                    <td>{data.zone}</td>
                    <td>{data.source}</td>
                </tr>
                )}
            </tbody>
        </table>

    );
};

export default Table;