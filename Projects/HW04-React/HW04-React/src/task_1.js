
/*
class CarTable extends React.Component {
    render() {
        //const [sort, setSort] = React.useState(null);
        return (

            <table>

                <tbody>
                    <tr>
                        <th>manufacturer</th>
                        <th>model</th>
                        <th>
                            <button type="button" onClick={() => setSort('year')}>
                                year</button>
                        </th>
                        <th>stock</th>
                        <th>price</th>
                        <th>option</th>
                    </tr>
                </tbody>
                
                <tbody>
                    {this.props.cars.map(car => (
                        <tr key={car.id}>
                            <td>{car.manufacturer}</td>
                            <td>{car.model}</td>
                            <td>{car.year}</td>
                            <td>{car.stock}</td>
                            <td>{car.price}</td>
                            <td>{car.option}</td>
                        </tr>
                    ))}
                </tbody>
            </table>



        );
    }
}
*/
class App extends React.Component {

    
    constructor(props) {
        super(props);
        
        this.state = {
            cars: [
                {
                    "id":1,
                    "manufacturer": "Toyota",
                    "model": "Rav4",
                    "year": 2008,
                    "stock": 3,
                    "price": 8500,
                    "option": <button> Increment</button>
                },

                {
                    "id": 2,
                    "manufacturer": "Toyota",
                    "model": "Camry",
                    "year": 2009,
                    "stock": 2,
                    "price": 6500,
                    "option":<button> Increment</button>
                },

                {

                    "id":3,
                    "manufacturer": "Toyo ta",
                    "model": "Tacoma",
                    "year": 2016,
                    "stock": 1,
                    "price": 22000,
                    "option":  <button> Increment</button>
                },

                {   "id":4,
                    "manufacturer": "BMW",
                    "model": "i3",
                    "year": 2012,
                    "stock": 5,
                    "price": 12000,
                    "option": <button> Increment</button>
                },

                {   "id":5,
                    "manufacturer": "Chevy",
                    "model": "Malibu",
                    "year": 2015,
                    "stock": 2,
                    "price": 10000,
                    "option":  <button> Increment</button>
                },

                {      "id":6,
                    "manufacturer": "Honda",
                    "model": "Accord",
                    "year": 2013,
                    "stock": 1,
                    "price": 9000,
                    "option":<button> Increment</button>
                },

                {   "id":7,
                    "manufacturer": "Hyundai",
                    "model": "Elantra",
                    "year": 2013,
                    "stock": 2,
                    "price": 7000,
                    "option":<button> Increment</button>
                },

                {   "id":8,
                    "manufacturer": "Chevy",
                    "model": "Cruze",
                    "year": 2012,
                    "stock": 2,
                    "price": 5500,
                    "option": <button> Increment</button>
                },

                {   "id":9,
                    "manufacturer": "Dodge",
                    "model": "Charger",
                    "year": 2013,
                    "stock": 2,
                    "price": 16000,
                    "option": <button> Increment</button>
                },

                {   "id":10,
                    "manufacturer": "Ford",
                    "model": "Mustang",
                    "year": 2009,
                    "stock": 1,
                    "price": 8000,
                    "option": <button>Increment</button>
                },

            ]
        };
        //this.handleIncrement = this.handleIncrement.bind(this);
    }

    /*
    renderTableData() {
        return this.state.cars.map((car, index) => {
            const { id, manufacturer, model, year, stock, price, option } = car
            return (
                
                <tr key={id}>
                    <td>{manufacturer}</td>
                    <td>{model}</td>
                    <td>{year}</td>
                    <td>{stock}</td>
                    <td>{price}</td>
                    <td>{option}</td>
                </tr>
                    
            )
                
        
        
        })
    }

    renderTableHeader() {
        let header = Object.keys(this.state.cars[0])
        return header.map((key, index) => {
            return <th key={index}>{key.toUpperCase()}</th>
        })
    }
    */
    
    const carTable = () => {
        const [sort, setSort] = React.useState(null);
        return (

            <table>

                <tbody>
                    <tr>
                        <th>manufacturer</th>
                        <th>model</th>
                        <th>
                            <button type="button" onClick={() => setSort('year')}>
                                year</button>
                        </th>
                        <th>stock</th>
                        <th>price</th>
                        <th>option</th>
                    </tr>
                </tbody>

                <tbody>
                    {this.state.cars.map(car => (
                        <tr key={car.id}>
                            <td>{car.manufacturer}</td>
                            <td>{car.model}</td>
                            <td>{car.year}</td>
                            <td>{car.stock}</td>
                            <td>{car.price}</td>
                            <td>{car.option}</td>
                        </tr>
                    ))}
                </tbody>
            </table>



        );
    }
    
    render() {
        
        return (

            /*    
            <div>
                
                <table id='cars'>
                    <tbody>
                        <tr>{this.renderTableHeader()}</tr>
                        {this.renderTableData()}
                    </tbody>
                </table>
                <ul>
                    {this.state.cars.map((car, index) => (
                        <li key={car}>
                            
              <button
                                type="button"
                                onClick={() => this.handleIncrement(index)}
                            >
                                plus
              </button>
                        </li>
                    ))}
                </ul>
            </div>
            */

            <div>
                {this.carTable()}
            </div>
            
            

        );
    }
}


ReactDOM.render(<App />, document.getElementById("app"));



