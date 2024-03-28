// MailRequest.cs

namespace EmailApplication.Model
{
    public class MailRequest
    {
        public string  Name { get; set; }
        public string  ToEmail { get; set; }
       //public string Subject { get; set; }
        public string Message { get; set; }
      //  public List<IFormFile>? Attachments { get; set; }
    }
}
