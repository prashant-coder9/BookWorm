using BookWorm_DotNet.DAL;
using BookWorm_DotNet.Models;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Net;

namespace Bookworm.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class CustomerController : ControllerBase
    {
        private readonly ICustomerRepository _customerRepository;

        public CustomerController(ICustomerRepository customerRepository)
        {
            _customerRepository = customerRepository;
        }

        [HttpPost("Add")]
        public IActionResult AddCustomer(Customer customer)
        {
           long id= _customerRepository.AddCustomer(customer);
            return Ok(id);
        }

        [HttpPost("Login")]
        public IActionResult Login(User user)
        {
            Customer customerResponse = _customerRepository.LoginUser(user.Email, user.Password);

            if (customerResponse != null)
            {
                return Ok(customerResponse);
            }
            else
            {
                return Unauthorized();
            }
        }

        [HttpGet("GetCustomerById/{customerId}")]
        public IActionResult GetCustomer(long customerId)
        {
            Customer customer = _customerRepository.GetCustomer(customerId);
            if (customer != null)
            {
                return Ok(customer);
            }
            else
            {
                return NotFound();
            }
        }
    }
}
