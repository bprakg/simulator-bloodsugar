const React = require('react');
const ReactDOM = require('react-dom')
const client = require('./client');

class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {foods: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/api/foods'}).done(response => {
			this.setState({foods: response.entity._embedded.foods});
		});
	}

	render() {
		return (
			<FoodList foods={this.state.foods}/>
		)
	}
}

class FoodList extends React.Component{
	render() {
		var employees = this.props.foods.map(employee =>
			<Food key={employee._links.self.href} food={food}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>Name</th>
						<th>Glycemic Index</th>
					</tr>
					{foods}
				</tbody>
			</table>
		)
	}
}

class Food extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.employee.name}</td>
				<td>{this.props.employee.glycemicIndex}</td>
			</tr>
		)
	}
}

ReactDOM.render(
		<App />,
		document.getElementById('react')
)